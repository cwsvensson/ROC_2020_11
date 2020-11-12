package my.app.jdbc.model;

public class Player {

	private int id;
	private String firstName;
	private String lastName;
	private String teamName;
	private int age;
	private String gender;
	private long contact;
	
	public Player() {
	}					// Empty constructor should not be used

	public Player(int id, String firstName, String lastName,
			      String teamName, int age, String gender, long contact) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.teamName = teamName;
		this.age = age;
		this.gender = gender;
		this.contact = contact;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "Player [Id=" + id + 
			    ", First Name=" + firstName +
			    ", Last Name="  + lastName + 
			    ", teamName="   + teamName +
			    ", contact="    + contact +
			    ", gender="  	+ gender +
			    ", age="        + age +        "]";
	}

	
}
