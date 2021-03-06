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
package org.jetel.ctl.debug;

import java.lang.Thread;
import org.jetel.graph.Node;

/**
 * This unit represents a Java thread together with a component
 * running in that thread. It represents a hint about CTL thread
 * when the CTL thread is not currently being executed and hence it is not known to the debug bean.
 * 
 * @author jan.michalica (info@cloveretl.com)
 *         (c) Javlin, a.s. (www.cloveretl.com)
 *
 * @created 5.5.2016
 */
public class NodeThread {

	private final Node node;
	private final Thread thread;
	private volatile boolean suspend;
	
	public NodeThread(Node node, Thread thread) {
		super();
		this.node = node;
		this.thread = thread;
	}

	public Node getNode() {
		return node;
	}
	
	public Thread getJavaThread() {
		return thread;
	}

	public boolean isSuspend() {
		return suspend;
	}

	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}
}
