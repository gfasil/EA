package com.ea.exercise01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String ISBN;
	@Column(name="author_name")
	private String author;
	private double price;
	@Temporal(TemporalType.DATE)
	private java.util.Date publish_date; 
	public Book() {
		
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Book  [id=" + id + ", title=" + title + ", ISBN=" + ISBN + ", author=" + author + ", price=" + price
				+ ", publish_date=" + publish_date + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public java.util.Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(java.util.Date publish_date) {
		this.publish_date = publish_date;
	}
	

}
