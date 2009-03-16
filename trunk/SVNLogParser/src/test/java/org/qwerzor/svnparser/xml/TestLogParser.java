/**
 * 
 */
package org.qwerzor.svnparser.xml;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.qwerzor.svnparser.model.Log;
import org.qwerzor.svnparser.model.LogEntry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author jeroenvs
 *
 */
public class TestLogParser {
	
	private Document document;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		document = DocumentParser.parseDocument(TestDocumentParser.TEST_LOG);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		document = null;
	}

	/**
	 * Test method for {@link org.qwerzor.svnparser.xml.LogParser#parseLog(org.w3c.dom.Document)}.
	 */
	@Test
	public void testParseLog() {
		try {
			Log log = LogParser.parseLog(document);
			Assert.assertNotNull(log);
		} catch (ParsingException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link org.qwerzor.svnparser.xml.LogParser#parseEntry(org.w3c.dom.Element)}.
	 */
	@Test
	@SuppressWarnings("deprecation")
	public void testParseEntry() {
		try {
			Element element = (Element) document.getElementsByTagName(LogParser.ENTRY_ID).item(0);
			LogEntry entry = LogParser.parseEntry(element);
			Assert.assertNotNull(entry);
			Assert.assertEquals(1214, entry.getRevision());
			Assert.assertEquals(new Date(2009,3,13,7,4,13), entry.getDate());
			Assert.assertEquals("matthias.vanneste", entry.getAuthor());
			Assert.assertNotNull(entry.getPaths());
			Assert.assertEquals("", entry.getMessage());
		} catch (ParsingException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link org.qwerzor.svnparser.xml.LogParser#parsePath(org.w3c.dom.Element)}.
	 */
	@Test
	public void testParsePath() {
		fail("");
	}

}
