package com.blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.blog.regex.RegexConstant;

@Entity
@Table(name = "Users_Detail")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_Id")
	private int id;

	@Column(name = "User_Name", nullable = false, length = 50, updatable = true)
	@NotNull
	@NotEmpty
	private String name;

	@Column(name = "Email", unique = true)
	@Pattern(regexp = RegexConstant.EMAIL, message = "Mail Should be Proper !")
	private String email;

	@NotEmpty
	@Size(min = 9, max = 15, message = "Password must be between 9 to 15 characters")
	@Column(name = "Password")
	private String password;

	@Column(name = "About_User")
	@NotBlank(message = "about field cannot be blank !")
	private String about;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> psots = new ArrayList<>();

	public User(int id, @NotNull @NotEmpty String name,
			@Pattern(regexp = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Mail Should be Proper !") String email,
			@NotEmpty @Size(min = 9, max = 15, message = "Password must be between 9 to 15 characters") String password,
			@NotBlank(message = "about field cannot be blank !") String about, List<Post> psots) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.psots = psots;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Post> getPsots() {
		return psots;
	}

	public void setPsots(List<Post> psots) {
		this.psots = psots;
	}

}
