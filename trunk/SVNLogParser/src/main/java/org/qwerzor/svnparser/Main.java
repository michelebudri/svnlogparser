package org.qwerzor.svnparser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.qwerzor.svnparser.xml.DocumentParser;
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
			System.out.println(document.toString());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

}