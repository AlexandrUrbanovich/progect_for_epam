package ru.mail.urbanovichalexandr.datamodel;

public class StudentCourses {
	private Integer studentId;
	private Student student;
	private Integer coursId;
	private Cours cours;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getCoursId() {
		return coursId;
	}

	public void setCoursId(Integer coursId) {
		this.coursId = coursId;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "StudentCourses [student=" + student + ", cours=" + cours + "]";
	}

}
