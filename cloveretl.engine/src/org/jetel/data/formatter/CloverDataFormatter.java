
/*
*    jETeL/Clover - Java based ETL application framework.
*    Copyright (C) 2005-06  Javlin Consulting <info@javlinconsulting.cz>
*    
*    This library is free software; you can redistribute it and/or
*    modify it under the terms of the GNU Lesser General Public
*    License as published by the Free Software Foundation; either
*    version 2.1 of the License, or (at your option) any later version.
*    
*    This library is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU    
*    Lesser General Public License for more details.
*    
*    You should have received a copy of the GNU Lesser General Public
*    License along with this library; if not, write to the Free Software
*    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*
*/

package org.jetel.data.formatter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.jetel.data.DataRecord;
import org.jetel.data.Defaults;
import org.jetel.exception.ComponentNotReadyException;
import org.jetel.metadata.DataRecordMetadata;
import org.jetel.util.bytes.ByteBufferUtils;
import org.jetel.util.file.FileUtils;


/**
 * Class for saving data in Clover internal format
 * Data are saved to zip file with structure:
 * DATA/fileName
 * INDEX/fileName.idx
 * METADATA/fileName.fmt
 * or to binary files
 * 
 * 
 * @author avackova <agata.vackova@javlinconsulting.cz> ; 
 * (c) JavlinConsulting s.r.o.
 *  www.javlinconsulting.cz
 *
 * @since Oct 12, 2006
 *
 */
public class CloverDataFormatter implements Formatter {
	
	public final static char FILE_SEPARATOR = '/';
	public final static String DATA_DIRECTORY = "DATA" + FILE_SEPARATOR;
	public final static String INDEX_DIRECTORY = "INDEX" + FILE_SEPARATOR;
	public final static String METADATA_DIRECTORY = "METADATA" + FILE_SEPARATOR;
	public final static String INDEX_EXTENSION = ".idx";
	public final static String METADATA_EXTENSION = ".fmt";
	public final static String TMP_EXTENSION = ".tmp";

	private WritableByteChannel writer;
	private OutputStream out;//FileOutputStream or ZipOutputStream
	private ByteBuffer buffer;
	private WritableByteChannel idxWriter;
	private ByteBuffer idxBuffer;
	private boolean saveIndex;
	private String fileURL;
	private String fileName;
	private File idxTmpFile;
	private ReadableByteChannel idxReader;
	private boolean append;
	private boolean isOpen = false;
	private URL projectURL;
	
	private final static short LEN_SIZE_SPECIFIER = 4;
	private final static int SHORT_SIZE_BYTES = 2;
	private final static int LONG_SIZE_BYTES = 8;

	
	/**
	 * Constructor
	 * 
	 * @param fileName name of archive or name of binary file with records
	 * @param saveIndex whether to save indexes of records or not 
	 */
	public CloverDataFormatter(String fileName,boolean saveIndex) {
		this.fileURL = fileName;
		this.saveIndex = saveIndex;
	}

	/* (non-Javadoc)
	 * @see org.jetel.data.formatter.Formatter#init(org.jetel.metadata.DataRecordMetadata)
	 */
	public void init(DataRecordMetadata _metadata)
			throws ComponentNotReadyException {
        buffer = ByteBuffer.allocateDirect(Defaults.DEFAULT_INTERNAL_IO_BUFFER_SIZE);
 	}

    /* (non-Javadoc)
     * @see org.jetel.data.formatter.Formatter#setDataTarget(java.lang.Object)
     */
    public void setDataTarget(Object outputDataTarget) {
        //create output stream
    	this.out = (OutputStream) outputDataTarget;
        try {
			this.fileName = new File(FileUtils.getFile(projectURL, fileURL)).getName();
		} catch (MalformedURLException e) {
			// can't happen - used for obtaining output stream
		}
		if (fileURL.endsWith(".zip")) {
			fileName = fileName.substring(0,fileName.lastIndexOf('.')); 
		}
		writer = Channels.newChannel(this.out);
        if (saveIndex) {//create temporary index file
            try{
                idxTmpFile = File.createTempFile(fileName, null);
                idxWriter = Channels.newChannel(new DataOutputStream(new FileOutputStream(idxTmpFile)));
            }catch(IOException ex){
                throw new RuntimeException(ex);
            }
            idxBuffer = ByteBuffer.allocateDirect(Defaults.DEFAULT_INTERNAL_IO_BUFFER_SIZE);
        }
        isOpen = true;
    }

    public void reset() {
		if (isOpen) {
			close();
		}
	}
	
    public void finish() throws IOException{
			flush();
			if (out instanceof ZipOutputStream) {
				((ZipOutputStream)out).closeEntry();
			}
			if (saveIndex) {
				idxReader = new FileInputStream(idxTmpFile).getChannel();
				if (idxTmpFile.length() > 0){//if some indexes were saved to tmp file, save the rest of indexes
					ByteBufferUtils.flush(idxBuffer,idxWriter);
					ByteBufferUtils.reload(idxBuffer,idxReader);
				}
				idxWriter.close();
				idxBuffer.flip();
				long startValue = 0;//first index
				int position;
				if (out instanceof ZipOutputStream) {
					//put entry INEX/fileName.idx
					((ZipOutputStream)out).putNextEntry(new ZipEntry(INDEX_DIRECTORY + fileName + INDEX_EXTENSION));
					//append indexes from tmp file 
					do {
						startValue = changSizeToIndex(startValue);
						position = buffer.position();
						flush();
					}while (position == buffer.limit());
					//clear up
					((ZipOutputStream)out).closeEntry();
					idxReader.close();
					idxTmpFile.delete();
				}else{//out instanceof FileOutputStream
			    	//get last old index
					if (append) {
						try{
							DataInputStream idxIn = new DataInputStream(FileUtils.getInputStream(projectURL, 
								fileURL + CloverDataFormatter.INDEX_EXTENSION));
							idxIn.skip(idxIn.available() - LONG_SIZE_BYTES);
							startValue = idxIn.readLong();
						} catch (IOException e) {
							// do nothing: index file apparently doesn't exist
						} 
					}
					//append indexes from tmp file 
					idxWriter = FileUtils.getWritableChannel(projectURL, fileURL + CloverDataFormatter.INDEX_EXTENSION, 
							append, -1);
					do {
						startValue = changSizeToIndex(startValue);
						position = buffer.position();
						ByteBufferUtils.flush(buffer,idxWriter);
					}while (position == buffer.limit());
					//clear up
					idxReader.close();
					idxTmpFile.delete();
					idxWriter.close();
				}
			}
    }
    
	/* (non-Javadoc)//			writer.close();

	 * @see org.jetel.data.formatter.Formatter#close()
	 */
	public void close() {
		if (!isOpen) return;
		try {
			if (writer.isOpen()) {
				writer.close();
			}
			isOpen = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method fills buffer with indexes created from records's sizes stored
	 *  in tmp file or idxBuffer
	 * 
	 * @param lastValue value to start from
	 * @return
	 * @throws IOException
	 */
	private long changSizeToIndex(long lastValue) throws IOException{
		short actualValue;
		while (buffer.remaining() >= LONG_SIZE_BYTES){
			if (idxBuffer.remaining() < SHORT_SIZE_BYTES ){//end of idxBuffer, reload it
				ByteBufferUtils.reload(idxBuffer,idxReader);
				idxBuffer.flip();
			}
			if (idxBuffer.remaining() < SHORT_SIZE_BYTES ){//there is no more sizes to working up
				break;
			}
			buffer.putLong(lastValue);
			actualValue = idxBuffer.getShort();
			//if negative value change to big Integer
			lastValue += actualValue > 0 ? actualValue : Short.MAX_VALUE - actualValue;
		}
		return lastValue;
	}

	/* (non-Javadoc)
	 * @see org.jetel.data.formatter.Formatter#write(org.jetel.data.DataRecord)
	 */
	public int write(DataRecord record) throws IOException {
		int recordSize = record.getSizeSerialized();
		if (saveIndex) {
			//if size is grater then Short, change to negative Short
			short index = recordSize + LEN_SIZE_SPECIFIER <= Short.MAX_VALUE ? 
					(short)(recordSize + LEN_SIZE_SPECIFIER) : 
					(short)(Short.MAX_VALUE - (recordSize + LEN_SIZE_SPECIFIER));
			if (idxBuffer.remaining() < SHORT_SIZE_BYTES){
				ByteBufferUtils.flush(idxBuffer,idxWriter);
			}
			idxBuffer.putShort(index);
		}
		if (buffer.remaining() < recordSize + LEN_SIZE_SPECIFIER){
			flush();
		}
		if (buffer.remaining() < recordSize + LEN_SIZE_SPECIFIER){
			throw new RuntimeException("The size of data buffer is only " + buffer.limit() + 
					", but record size is " + recordSize + ". Set appropriate parameter in defautProperties file.");
		}
		buffer.putInt(recordSize);
		record.serialize(buffer);
        
        return recordSize + LEN_SIZE_SPECIFIER;
	}

	/* (non-Javadoc)
	 * @see org.jetel.data.formatter.Formatter#flush()
	 */
	public void flush() throws IOException {
		ByteBufferUtils.flush(buffer,writer);
		out.flush();
	}
	
	public boolean isSaveIndex() {
		return saveIndex;
	}

	public boolean isAppend() {
		return append;
	}

	public void setAppend(boolean append) {
		this.append = append;
	}

	public int writeFooter() throws IOException {
		return 0;
	}

	public int writeHeader() throws IOException {
		return 0;
	}

	public void setProjectURL(URL projectURL) {
		this.projectURL = projectURL;
	}

}
