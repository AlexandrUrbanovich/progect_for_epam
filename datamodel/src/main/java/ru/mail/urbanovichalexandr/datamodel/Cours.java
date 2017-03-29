package ru.mail.urbanovichalexandr.datamodel;

public class Cours {
	private Integer coursId;
	private String nameCours;
	private Integer teacherId;
	
	public Integer getCoursId() {
		return coursId;
	}
	
	public void setCoursId(Integer coursId) {
		this.coursId = coursId;
	}
	
	public String getNameCours() {
		return nameCours;
	}
	
	public void setNameCours(String nameCours) {
		this.nameCours = nameCours;
	}
	
	public Integer getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "Cours [coursId=" + coursId + ", nameCours=" + nameCours + ", teacherId=" + teacherId + "]";
	}

}
