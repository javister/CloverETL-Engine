/*
 * jETeL/CloverETL - Java based ETL application framework.
 * Copyright (c) Javlin, a.s. (info@cloveretl.com)
 *  
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.jetel.data.xsd;

import javax.xml.bind.DatatypeConverter;
import org.apache.log4j.Logger;
import org.jetel.exception.DataConversionException;
import org.jetel.metadata.DataFieldMetadata;

/**
 *
 * @author Pavel Pospichal
 */
public class CloverLongConvertor implements IGenericConvertor {

    private static Logger logger = Logger.getLogger(CloverLongConvertor.class);
    
    static {
    	ConvertorRegistry.registerConvertor(new CloverLongConvertor());
    }
    
    public static Long parseXsdLongToLong(String value) throws DataConversionException {
    	Long result = null;
        
		try {
			result = DatatypeConverter.parseLong(value);
		} catch (Exception e) {
			logger.fatal("Unable to parse xsd:long to " + Long.class.getName() + ".", e);
			throw new DataConversionException("Unable to parse xsd:long to " + Long.class.getName() + ".", e);
		}
        
        return result;
    }
    
    public static String printLongToXsdLong(Long value) throws DataConversionException {
        String result = null;
        
        try {
			result = DatatypeConverter.printLong(value);
		} catch (Exception e) {
			logger.fatal("Unable to print " + Long.class.getName() + " to xsd:long.", e);
			throw new DataConversionException("Unable to print " + Long.class.getName() + " to xsd:long.", e);
        }
        
        return result;
    }

    @Override
	public Object parse(String input) throws DataConversionException {
        return parseXsdLongToLong(input);
    }

    @Override
	public String print(Object obj) throws DataConversionException {
        if (!(obj instanceof Long)) {
            throw new DataConversionException("Unsupported type by convertion: " + obj.getClass().getName());
        }

        return printLongToXsdLong((Long) obj);
    }

	@Override
	public boolean supportsCloverType(String cloverDataTypeCriteria) {
		return DataFieldMetadata.LONG_TYPE.equals(cloverDataTypeCriteria);
	}
	
	@Override
	public boolean supportsExternalSystemType(String externalTypeCriteria) {
		return true;
	}
}
