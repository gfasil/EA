package edu.mum.cs.cs544.exercises;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	
	public Owner(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Owner() {}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	

}
