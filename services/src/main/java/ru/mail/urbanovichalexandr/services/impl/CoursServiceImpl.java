package ru.mail.urbanovichalexandr.services.impl;

import java.util.List;

import javax.inject.Inject;

import ru.mail.urbanovichalexandr.dao.impl.db.ICoursDao;
import ru.mail.urbanovichalexandr.datamodel.Cours;
import ru.mail.urbanovichalexandr.servises.ICoursServiсes;

public class CoursServiceImpl implements ICoursServiсes {
	
	@Inject
	private ICoursDao coursDao;

	@Override
	public Cours get(Integer coursId) {
		return coursDao.get(coursId);
	}

	@Override
	public void save(Cours cours) {
		if(cours.getCoursId()==null){
			System.out.println("Insert new student");
			coursDao.insert(cours);
		} else {
			coursDao.update(cours);
		}
	}

	@Override
	public void saveMultiple(Cours... courses) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cours> gelAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer coursId) {
		// TODO Auto-generated method stub
		
	}

}
