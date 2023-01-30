package org.iclass.vo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public class NewMember 
{
	// field - column
	private String id;
	private String name;
	private String password;
	private String email;
	private int age;
	private String gender;		// 남성 : true, 여성 : false
	private String hobbies;		// 취미를 , 로 나열
	private LocalDateTime joinDate;
	private Timestamp joinDate2;
		
	// constructor
	public NewMember() {}

	public NewMember(String id, String name, String password, String email, int age, String gender, String hobbies,
			LocalDateTime joinDate, Timestamp joinDate2) 
	{
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.hobbies = hobbies;
		this.joinDate = joinDate;
		this.joinDate2 = joinDate2;
	}

	@Override
	public String toString() 
	{
		return "NewMember [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", hobbies=" + hobbies + ", joinDate=" + joinDate + ", joinDate2=" + joinDate2
				+ "]";
	}
	
	// getter
	public String getId() 
	{return id;}

	public String getName()
	{return name;}

	public String getPassword() 
	{return password;}
	
	public String getEmail() 
	{return email;}

	public int getAge() 
	{return age;}

	public String getGender() 
	{return gender;}

	public String getHobbies() 
	{return hobbies;}

	public LocalDateTime getJoinDate()
	{return joinDate;}

	public Timestamp getJoinDate2() 
	{return joinDate2;}
}	// Class end
