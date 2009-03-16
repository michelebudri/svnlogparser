package org.qwerzor.svnparser.xml;

import java.util.ArrayList;
import java.util.Date;

import org.qwerzor.svnparser.model.Log;
import org.qwerzor.svnparser.model.LogEntry;
import org.qwerzor.svnparser.model.Path;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Parse XML document object into a specific Log model.
 * 
 * @author jeroenvs
 * @date 16-03-2009
 */
public class LogParser {
	
	public static final String ENTRY_ID = "logentry";
	
	public static final String REVISION_ID = "revision";
	public static final String AUTHOR_ID = "author";
	public static final String DATE_ID = "date";
	public static final String PATHS_ID = "paths";
	public static final String MESSAGE_ID = "msg";	
	
	public static final String PATH_ID = "path";
	public static final String ACTION_ID = "action";

	public static Log parseLog(Document document) throws ParsingException {
		Log log = new Log();
		
		if(document == null) { return log; }
		
		// Attach entries
		ArrayList<LogEntry> entries = new ArrayList<LogEntry>();
		NodeList elements = document.getElementsByTagName(ENTRY_ID);
		for(int i = 0; i < elements.getLength(); i++) {
			entries.add(parseEntry((Element) elements.item(i)));
		}
		
		return log;
	}
	
	@SuppressWarnings("deprecation")
	public static LogEntry parseEntry(Element element) throws ParsingException {
		LogEntry entry = new LogEntry();
		
		// Retrieve revision number
		String revision = "";
		try {
			revision = element.getAttribute(REVISION_ID);
			entry.setRevision(Integer.parseInt(revision));
		} catch(NumberFormatException e) {
			throw new ParsingException(revision + " is not a valid revision number");
		}
		
		// Retrieve author
		String author = getTextValue(element, AUTHOR_ID);
		entry.setAuthor(author);
		
		// Retrieve date
		String date = getTextValue(element, DATE_ID);
		try {
			// Format date
			date = date.replace("Z", "");
			date = date.replace("T", ":");
			date = date.replace("-", ":");
			
			// Split date
			String[] dt = date.split(":");
			if(dt.length != 6) { 
				throw new ParsingException(date + " is not a valid date");
			}
			
			// Store date
			entry.setDate(new Date(
					Integer.parseInt(dt[0]), Integer.parseInt(dt[1]) - 1, 
					Integer.parseInt(dt[2]), Integer.parseInt(dt[3]), 
					Integer.parseInt(dt[4]), (int) Double.parseDouble(dt[5])
				));
		} catch(NumberFormatException e) {
			throw new ParsingException(date + " is not a valid date", e);
		}
		
		// TODO: Retrieve paths
		
		
		// Retrieve message
		String message = getTextValue(element, MESSAGE_ID);
		entry.setMessage(message);
		
		return entry;
	}
	
	public static Path parsePath(Element element) throws ParsingException {
		Path path = new Path();
		
		System.out.println(element.toString());
		
		return path;
	}
	
	/**
	 * Retrieve text value of sub element.
	 * @param parent Parent element
	 * @param identifier Identifier
	 * @return Value of sub element
	 */
	public static String getTextValue(Element parent, String identifier) {
		try {
			Node element = parent.getElementsByTagName(identifier).item(0);
			Node value = element.getChildNodes().item(0);
			return value.getNodeValue();
		} catch(NullPointerException e) {
			return "";
		}
	}
	
}