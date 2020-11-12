package com.player.model;

public class Player {

	private int id;
	private String firstName;
	private String lastName;
	private String teamName;
	private long contact;
	private String gender;
	private int age;
	
	public Player() {
	}

	public Player(int id, String firstName, String lastName, String teamName,int age, long contact, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.teamName = teamName;
		this.contact = contact;
		this.gender = gender;
		this.age=age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName +
				", teamName=" + teamName + ", contact=" + contact + ", gender="	+ gender +
				", age=" + age + "]";
	}
	
}
