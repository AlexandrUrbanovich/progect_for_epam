package ru.mail.urbanovichalexandr.datamodel;

import ru.mail.urbanovichalexandr.datamodel.enu.UserRole;

public class User {
	private Integer userId;
	private Integer teacherId;
	private Integer studentId;
	private String login;
	private Integer password;
	private UserRole role;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", teacherId=" + teacherId + ", studentId=" + studentId + ", login=" + login
				+ ", password=" + password + "]";
	}

}
