package org.qwerzor.svnparser.xml;

import java.util.ArrayList;
import java.util.Date;

import org.qwerzor.svnparser.model.Log;
import org.qwerzor.svnparser.model.LogEntry;
import org.qwerzor.svnparser.model.Path;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
			date.replace("T", null);
			date.replace("Z", null);
			System.out.println(date);
			//entry.setDate(new Date(Date.parse(date)));
		} catch(Exception e) {
			throw new ParsingException(date + " is not a valid date");
		}
		
		return entry;
	}
	
	public static Path parsePath(Element element) throws ParsingException {
		Path path = new Path();
		
		System.out.println(element.toString());
		
		return path;
	}
	
	public static String getTextValue(Element element, String identifier) {
		return element.getElementsByTagName(identifier).item(0).getNodeValue();
	}
	
}