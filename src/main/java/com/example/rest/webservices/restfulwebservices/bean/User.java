package com.example.rest.webservices.restfulwebservices.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@ApiModel(description = "some descirption about the User")
public class User {

	private Integer id;

	@Size(min = 2, message = "Name must contain more than one characters")
	private String name;

	@Email(message = "Email should look like name@domain.com")
	private String email;

	@Past
	@ApiModelProperty(notes = "Birthdate should be in the past")
	private Date birthDate;

	protected User() {
	}

	public User(Integer id, String name, String email, Date birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", birthDate=" + birthDate +
				'}';
	}
}
