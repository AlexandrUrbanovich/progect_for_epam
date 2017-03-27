package ru.mail.urbanovichalexandr.dao.impl.db;

import java.util.List;

import ru.mail.urbanovichalexandr.datamodel.Student;

public interface IStudentDao {
	
	Student get(Integer studentId);
	
	Student insert(Student student);
	
	void update(Student student);
	
	List<Student> getAll();
	
	void delete(Integer studentId);

}
