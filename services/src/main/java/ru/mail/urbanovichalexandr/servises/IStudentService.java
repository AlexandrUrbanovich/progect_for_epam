package ru.mail.urbanovichalexandr.servises;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.mail.urbanovichalexandr.datamodel.Student;

public interface IStudentService {
	
	 Student get(Integer idStudent);
	
	 @Transactional
	 void save(Student student);
	 
	 @Transactional
	 void saveMultiple(Student...students);
	 
	 List<Student> getAll();
	 
	 @Transactional
	 void delete(Integer idStudent);

}