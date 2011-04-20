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
package org.jetel.component.xml.writer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


public class StaxPrettyPrintHandler implements InvocationHandler {

	private XMLStreamWriter target;

	private int depth = 0;
	private Map<Integer, Boolean> hasChildElement = new HashMap<Integer, Boolean>();
	
	private static final char INDENT = ' ';
	private static final char LINE_FEED = '\n';

	public StaxPrettyPrintHandler(XMLStreamWriter target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		String m = method.getName();

		if ("writeStartElement".equals(m)) {
			// update state of parent node
			if (depth > 0) {
				hasChildElement.put(depth - 1, true);
			}

			// reset state of current node
			hasChildElement.put(depth, false);

			// indent for current depth
			indent(depth);

			depth++;

		} else if ("writeEndElement".equals(m)) {
			depth--;

			if (hasChildElement.get(depth) == true) {
				indent(depth);
			}

		} else if ("writeEmptyElement".equals(m) || "writeComment".equals(m)) {
			// update state of parent node
			if (depth > 0) {
				hasChildElement.put(depth - 1, true);
			}

			// indent for current depth
			indent(depth);
			
		}
		
		return method.invoke(target, args);
	}

	private void indent(int depth) throws XMLStreamException {
		char[] indent = new char[(depth << 1) + 1];
		indent[0] = LINE_FEED;
		Arrays.fill(indent, 1, indent.length, INDENT);

		target.writeCharacters(indent, 0, indent.length);
	}
}