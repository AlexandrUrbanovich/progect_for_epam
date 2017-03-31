package ru.mail.urbanovichalexandr.servises;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.mail.urbanovichalexandr.datamodel.Cours;

public interface ICoursServiсes {
	
	Cours get(Integer coursId);
	
	@Transactional
	void save(Cours cours);
	
	@Transactional
	void saveMultiple(Cours...courses);
	
	List<Cours> gelAll();
	
	@Transactional
	void delete(Integer coursId);

}