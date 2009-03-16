package org.qwerzor.svnparser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.qwerzor.svnparser.model.Log;
import org.qwerzor.svnparser.xml.DocumentParser;
import org.qwerzor.svnparser.xml.LogParser;
import org.qwerzor.svnparser.xml.ParsingException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Main {

	public static final String TEST_LOG = "data/test/svn.log";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Document document = DocumentParser.parseDocument(TEST_LOG);
			Log log = LogParser.parseLog(document);
			System.out.println("LOLS " + log.toString());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (ParsingException e) {
			e.printStackTrace();
		}
	}

}