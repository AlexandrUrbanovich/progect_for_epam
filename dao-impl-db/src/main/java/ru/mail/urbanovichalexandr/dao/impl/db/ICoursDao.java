package ru.mail.urbanovichalexandr.dao.impl.db;

import java.util.List;

import ru.mail.urbanovichalexandr.datamodel.Cours;



public interface ICoursDao {

	Cours get(Integer coursId);
	
	Cours insert(Cours cours);
	
	void update(Cours cours);
	
	List<Cours> getAll();
	
	void delete(Integer coursId);
}
