package ru.mail.urbanovichalexandr.services.impl;

import java.util.List;

import javax.inject.Inject;

import ru.mail.urbanovichalexandr.dao.impl.db.IEndDao;
import ru.mail.urbanovichalexandr.datamodel.End;
import ru.mail.urbanovichalexandr.servises.IEndServices;

public class EndServisesImpl implements IEndServices {
	
	@Inject
	private IEndDao endDao;

	@Override
	public End get(Integer studentId) {
		return endDao.get(studentId);
	}

	@Override
	public void save(End end) {
		if(end.getCoursId()==null){
			System.out.println("Insert new end");
			endDao.insert(end);
		} else {
			endDao.update(end);
		}
	}

	@Override
	public void saveMultiple(End... endArray) {
		for(End end: endArray){
			save(end);
		}
	}

	@Override
	public List<End> getAll() {
		return endDao.getAll();
	}

	@Override
	public void delete(Integer studentId) {
		endDao.delete(studentId);
	}

}
