package ru.mail.urbanovichalexandr.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ru.mail.urbanovichalexandr.dao.impl.db.ITeacherDao;
import ru.mail.urbanovichalexandr.datamodel.Teacher;
import ru.mail.urbanovichalexandr.servises.ITeacherServices;

@Service
public class TeacherServiceImpl implements ITeacherServices {
	
	@Inject
	private ITeacherDao teacherDao;

	@Override
	public Teacher get(Integer teacherId) {
		return teacherDao.get(teacherId);
	}

	@Override
	public void save(Teacher teacher) {
		if(teacher.getTeacherId()==null){
			System.out.println("Insetr new teacher");
			teacherDao.insert(teacher);
		} else{
			teacherDao.update(teacher);
		}
	}

	@Override
	public void saveMultiple(Teacher... teacherArray) {
		for(Teacher teacher: teacherArray){
			save(teacher);
		}
	}

	@Override
	public List<Teacher> getAll() {
		return teacherDao.getAll();
	}

	@Override
	public void delete(Integer teacherId) {
		teacherDao.delete(teacherId);
	}

}
