package ru.mail.urbanovichalexandr.servises;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.mail.urbanovichalexandr.datamodel.Teacher;

public interface ITeacherServices {

	Teacher get(Integer teacherId);
	
	@Transactional
	void save(Teacher teacher);
	
	@Transactional
	void saveMultiple(Teacher...teacher);
	
	List<Teacher> getAll();
	
	@Transactional
	void delete(Integer teacherId);
}
