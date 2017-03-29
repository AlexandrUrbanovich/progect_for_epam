package ru.mail.urbanovichalexandr.datamodel;

public class Teacher {
	private Integer teacherId;
	private String firstname;
	private String lastname;
	private Integer userId;
	
	public Integer getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstname=" + firstname + ", lastname=" + lastname + ", userId="
				+ userId + "]";
	}
	
}
