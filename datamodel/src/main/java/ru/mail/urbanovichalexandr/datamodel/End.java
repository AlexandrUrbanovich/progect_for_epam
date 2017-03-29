package ru.mail.urbanovichalexandr.datamodel;

public class End {
	private Integer studentId;
	private Integer mark;
	private String text;
	private Integer coursId;
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public Integer getMark() {
		return mark;
	}
	
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Integer getCoursId() {
		return coursId;
	}
	
	public void setCoursId(Integer coursId) {
		this.coursId = coursId;
	}

	@Override
	public String toString() {
		return "End [studentId=" + studentId + ", mark=" + mark + ", text=" + text + ", coursId=" + coursId + "]";
	}
}
