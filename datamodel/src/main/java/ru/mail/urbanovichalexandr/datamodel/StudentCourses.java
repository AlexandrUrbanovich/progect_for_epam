package ru.mail.urbanovichalexandr.datamodel;

public class StudentCourses {
	private Integer studentId;
	private Integer coursId;
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public Integer getCoursId() {
		return coursId;
	}
	
	public void setCoursId(Integer coursId) {
		this.coursId = coursId;
	}

	@Override
	public String toString() {
		return "StudentCourses [studentId=" + studentId + ", coursId=" + coursId + "]";
	}

}
