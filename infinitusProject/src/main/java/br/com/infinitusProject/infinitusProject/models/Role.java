package br.com.infinitusProject.infinitusProject.models;

import javax.persistence.*;

import lombok.Data; 

@Entity
@Table(name = "role")
public class Role {
	//Larissa - Model dos "Papéis" existentes na aplicação 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
	@Column(name = "role")
    private String role;
	
	
	public int getId() {
		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
	
    @Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}

}
