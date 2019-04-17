package br.com.infinitusProject.infinitusProject.models;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
@Data
@Builder
@Entity
@Table(name = "[user]")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "*Por favor, informe um e-mail válido.")
    @NotEmpty(message = "*Por favor, informe seu e-mail.")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Sua senha deve ter ao menos 5 caracteres.")
    @NotEmpty(message = "*Por favor, informe sua senha.")
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "*")
    private String lastName;
    @Column(name = "active")
    private int active;   
    /*@Column(name = "zip_code")
    @NotEmpty(message = "*")*/
    @Transient
    private String zipCode;
    /*@Column(name = "state")
    @NotEmpty(message = "*")*/
    @Transient
    private String state; 
    /*@Column(name = "city")
    @NotEmpty(message = "*")*/
    @Transient
    private String city; 
    /*@Column(name = "neighborhood")
    @NotEmpty(message = "*")*/
    @Transient
    private String neighborhood; 
    /*@Column(name = "address")
    @NotEmpty(message = "*")*/
    @Transient
    private String address; 
    /*@Column(name = "readlike")*/
    @Transient
    private String readlike; 
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
        
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReadlike() {
		return readlike;
	}
	public void setReadlike(String readlike) {
		this.readlike = readlike;
	}
}