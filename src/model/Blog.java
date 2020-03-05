package model;

import java.time.LocalDate;

public class Blog {
	private String blogTitle;
	private String blogDescription;
	private LocalDate date;
	
	public Blog(String blogTitle, String blogDescription, LocalDate date) {
		
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.date = date;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
