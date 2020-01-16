package cs544.exercise02_2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private long id; 
	private String firstName; 
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth; 
	
	public Person() {
	}

	

	public Person(String firstName, String lastName, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}



	public long getId() {
		return id;
	}

	private void setId(long id) {
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	} 
	
	
	
	
	
}
