package br.com.JavaEmail.JavaEmail.models;

import org.springframework.stereotype.Component;

@Component
public class UserBookRequest {
	private String emailOwner; 
	private String emailPersonInterested; 
	private Long idBook;
	
	public UserBookRequest() {}
	
	public UserBookRequest(String emailOwner, String emailPersonInterested, Long idBook) {
		super();
		this.emailOwner = emailOwner;
		this.emailPersonInterested = emailPersonInterested;
		this.idBook = idBook;
	}
	public String getEmailOwner() {
		return emailOwner;
	}
	public void setEmailOwner(String emailOwner) {
		this.emailOwner = emailOwner;
	}
	public String getEmailPersonInterested() {
		return emailPersonInterested;
	}
	public void setEmailPersonInterested(String emailPersonInterested) {
		this.emailPersonInterested = emailPersonInterested;
	}
	public Long getIdBook() {
		return idBook;
	}
	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}
	@Override
	public String toString() {
		return "UserBookRequest [emailOwner=" + emailOwner + ", emailPersonInterested=" + emailPersonInterested
				+ ", idBook=" + idBook + "]";
	} 
	
	

}
