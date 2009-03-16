package org.qwerzor.svnparser.model;

import java.util.Date;

import org.hibernate.mapping.List;

/**
 * 
 * @author jeroenvs
 *
 */
public class Logentry {

	private int revision;
	private Date date;
	private String author;
	private List paths;
	private String message;
	
	public int getRevision() {
		return revision;
	}
	
	public void setRevision(int revision) {
		this.revision = revision;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public List getPaths() {
		return paths;
	}
	
	public void setPaths(List paths) {
		this.paths = paths;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}