package ru.mail.urbanovichalexandr.datamodel;

public class Student {
	private Integer studentId;
	private String firstName;
	private String lastName;
	private Integer kurs;
	private Integer userId;
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public Integer getKurs() {
		return kurs;
	}

	public void setKurs(Integer kurs) {
		this.kurs = kurs;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Student [studentId = " + studentId + ", firstName = " + firstName + ", lastName = " + lastName + ", kurs = "
				+ kurs + ", userId = " + userId + "]";
	}
	
}
