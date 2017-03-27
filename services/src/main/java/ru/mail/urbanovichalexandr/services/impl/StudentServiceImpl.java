package ru.mail.urbanovichalexandr.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ru.mail.urbanovichalexandr.dao.impl.db.IStudentDao;
import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.servises.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Inject
	private IStudentDao studentDao;
	
	@Value("${key1}")
	private String key1;

	@Value("${key2}")
	private Integer key2;
	
	@Override
	public Student get(Integer studentId) {
		return studentDao.get(studentId);
	}

	@Override
	public void save(Student student) {
		if(student.getStudentId()==null){
			System.out.println("Insert new student");
			studentDao.insert(student);
		} else {
			studentDao.update(student);
		}
		
	}

	@Override
	public void saveMultiple(Student... studentArray) {
		for(Student student: studentArray){
			save(student);
		}
	}

	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}

	@Override
	public void delete(Integer studentId) {
		studentDao.delete(studentId);
		
	}

}
