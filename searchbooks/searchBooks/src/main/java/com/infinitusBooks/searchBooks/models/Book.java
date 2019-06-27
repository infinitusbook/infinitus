package com.infinitusBooks.searchBooks.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name="books")
public class Book {
	//Larissa - Model de informações sobre os livros 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	private String title;  
	private String author; 
	private String publisher; 
	private String action;
	private String plusInformation;
	private String available; 
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
		
	public String getEmail() {
		return user.getEmail();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPlusInformation() {
		return plusInformation;
	}
	public void setPlusInformation(String plusInformation) {
		this.plusInformation = plusInformation;
	}
	
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
				
}
