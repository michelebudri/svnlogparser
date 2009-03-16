package org.qwerzor.svnparser.model;

import org.hibernate.mapping.List;

/**
 * Log structure, which contains 0..* entries
 * 
 * @author jeroenvs
 * @date 16-03-2009
 */
public class Log {

	/**
	 * Log entries.
	 */
	private List entries;

	/**
	 * Retrieve entries.
	 * @return Entries
	 */
	public List getEntries() {
		return entries;
	}

	/**
	 * Change entries.
	 * @param entries Entries collection
	 */
	public void setEntries(List entries) {
		this.entries = entries;
	}

}