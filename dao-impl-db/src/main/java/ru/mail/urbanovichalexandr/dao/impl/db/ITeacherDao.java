package ru.mail.urbanovichalexandr.dao.impl.db;

import java.util.List;

import ru.mail.urbanovichalexandr.datamodel.Teacher;

public interface ITeacherDao {
	
	Teacher get(Integer teacherId);
	
	Teacher insert(Teacher teacher);
	
	void update(Teacher teacher);
	
	List<Teacher> getAll();
	
	void delete(Integer teacherId);

}
