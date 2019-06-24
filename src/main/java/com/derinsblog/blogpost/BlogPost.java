package com.derinsblog.blogpost;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class BlogPost {
		@Id
		@GeneratedValue
	 	private long id; 
	    private String title;
		private String author;
		private String blogEntry;
		
		public BlogPost(String title, String author, String blogEntry) {
			this.title = title; 
			this.author = author;
			this.blogEntry = blogEntry;
		}
		public long getId() {
			return id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getBlogEntry() {
			return blogEntry;
		}
		public void setBlogEntry(String blogEntry) {
			this.blogEntry = blogEntry;
		}
		//empty const
		public BlogPost() {
			
		}
		@Override
		public String toString() {
			return "Id: "+ id +"Title: "+title +" Author: "+ author +" Blog: "+ blogEntry; 
		}
		
}
