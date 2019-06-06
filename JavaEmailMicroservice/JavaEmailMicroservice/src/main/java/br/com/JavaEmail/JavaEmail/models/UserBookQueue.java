package br.com.JavaEmail.JavaEmail.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name="user_book_queue")
public class UserBookQueue {
	//Larissa - Model de informações sobre a fila 
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id; 
		private String title;  
		private String author; 
		private String publisher; 
		private String action;	
		private String plusInformation; 
		private String available;
		private int position;
		private String emailPersonInterested; 
					
		public UserBookQueue() {}
		
		public UserBookQueue(Long id, String title, String author, String publisher, String action,
				String plusInformation, String available, int position, String emailPersonInterested) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.publisher = publisher;
			this.action = action;
			this.plusInformation = plusInformation;
			this.available = available;
			this.position = position;
			this.emailPersonInterested = emailPersonInterested;
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

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
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

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public String getEmailPersonInterested() {
			return emailPersonInterested;
		}

		public void setEmailPersonInterested(String emailPersonInterested) {
			this.emailPersonInterested = emailPersonInterested;
		}
		
}
