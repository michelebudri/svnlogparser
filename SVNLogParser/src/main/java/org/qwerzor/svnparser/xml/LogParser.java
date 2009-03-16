package org.qwerzor.svnparser.xml;

import org.qwerzor.svnparser.model.Log;
import org.w3c.dom.Document;

/**
 * Parse XML document object into a specific Log model.
 * 
 * @author jeroenvs
 * @date 16-03-2009
 */
public class LogParser {

	public Log parseLog(Document document) {
		Log log = new Log();
		
		if(document == null) { return log; }
		
		// Attach entries
		
		
		return log;
	}
	
}