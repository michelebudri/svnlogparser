package org.qwerzor.svnparser.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestDocumentParser extends TestCase {

	public static final String TEST_LOG = "data/test/svn.log";
	
	public void testParseDocument() {
		try {
			Document document = DocumentParser.parseDocument(TEST_LOG);
			Assert.assertNotNull(document);
		} catch (SAXException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (ParserConfigurationException e) {
			fail(e.getMessage());
		}
	}

}