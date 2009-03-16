package org.qwerzor.svnparser.model;

/**
 * Modification path.
 * 
 * <blockquote>
 * 	Example in svn --xml log:
 * 	<path action="M">/src/blaat.java</path>
 * </blockquote>
 * 
 * @author jeroenvs
 * @date 16-03-2009
 */
public class Path {

	/**
	 * Action type.
	 * 
	 * <pre>
	 * A: Added
	 * M: Modified
	 * D: Deleted
	 * </pre>
	 */
	private String action;
	
	/**
	 * Location of altered file.
	 */
	private String uri;
	
	/**
	 * Retrieve action type.
	 * @return
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * Change action type.
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * Retrieve path uri.
	 * @return
	 */
	public String getUri() {
		return uri;
	}
	
	/**
	 * Change path uri.
	 * @param uri
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

}