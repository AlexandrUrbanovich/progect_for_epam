package ru.mail.urbanovichalexandr.servises;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.mail.urbanovichalexandr.datamodel.StudentCourses;


public interface IStudentCoursesServices {

	StudentCourses get(Integer studentId);
	
	 @Transactional
	 void save(StudentCourses student);
	 
	 @Transactional
	 void saveMultiple(StudentCourses...student);
	 
	 List<StudentCourses> getAll();
	 
	 @Transactional
	 void delete(Integer studentId);
}