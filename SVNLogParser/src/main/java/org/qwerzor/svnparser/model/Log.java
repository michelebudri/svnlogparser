package org.qwerzor.svnparser.model;

import org.hibernate.mapping.List;

/**
 * 
 * @author jeroenvs
 *
 */
public class Log {

	private List entries;

	/**
	 * 
	 * @return
	 */
	public List getEntries() {
		return entries;
	}

	/**
	 * 
	 * @param entries
	 */
	public void setEntries(List entries) {
		this.entries = entries;
	}

}