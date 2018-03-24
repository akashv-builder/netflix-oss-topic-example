package com.main.showtopic;

import javax.validation.constraints.Size;

public class Topic {

	private String id;
	//applying validatons
	@Size(min=2,message="Name should be atleast of length 2")
	private String name;
	private String description;
	private String firstName;


	public Topic() {
		super();

	}

	public Topic(String id, String name,
			String description, String firstName) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
