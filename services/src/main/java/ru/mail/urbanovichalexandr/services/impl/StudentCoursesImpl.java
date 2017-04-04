package ru.mail.urbanovichalexandr.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ru.mail.urbanovichalexandr.dao.impl.db.IStudentCoursesDao;
import ru.mail.urbanovichalexandr.datamodel.StudentCourses;
import ru.mail.urbanovichalexandr.servises.IStudentCoursesServices;

@Service
public class StudentCoursesImpl implements IStudentCoursesServices {

	@Inject
	private IStudentCoursesDao studentCoursesDao;
	
	@Override
	public StudentCourses get(Integer studentId) {
		return studentCoursesDao.get(studentId);
	}

	@Override
	public void save(StudentCourses student) {
		if(student.getStudentId()==null){
			System.out.println("Insert new student in student_courses");
			studentCoursesDao.insert(student);
		} else {
			studentCoursesDao.update(student);
		}
	}

	@Override
	public void saveMultiple(StudentCourses... student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentCourses> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer studentId) {
		// TODO Auto-generated method stub
		
	}

}
