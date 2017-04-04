package ru.mail.urbanovichalexandr.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ru.mail.urbanovichalexandr.dao.impl.db.ICoursDao;
import ru.mail.urbanovichalexandr.datamodel.Cours;
import ru.mail.urbanovichalexandr.servises.ICoursServiсes;


@Service
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
			System.out.println("Insert new cours");
			coursDao.insert(cours);
		} else {
			coursDao.update(cours);
		}
	}

	@Override
	public void saveMultiple(Cours... coursArray) {
		for(Cours cours: coursArray){
			save(cours);
		}
	}

	@Override
	public List<Cours> gelAll() {
		return coursDao.getAll();
	}

	@Override
	public void delete(Integer coursId) {
		coursDao.delete(coursId);		
	}

}
