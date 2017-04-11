package ru.mail.urbanovichalexandr.dao.api;

import java.util.List;

import ru.mail.urbanovichalexandr.datamodel.StudentCourses;


public interface IStudentCoursesDao {

	StudentCourses get(Integer studentId);

	void update(StudentCourses studentCourses);

	List<StudentCourses> getAll();

	void delete(Integer studentId);
	
	StudentCourses getStudentWithCours(Integer studentId);

	void insert(StudentCourses student);

}
