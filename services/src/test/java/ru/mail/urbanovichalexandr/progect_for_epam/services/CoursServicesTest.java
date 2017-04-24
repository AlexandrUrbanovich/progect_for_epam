package ru.mail.urbanovichalexandr.progect_for_epam.services;


import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.datamodel.Cours;
import ru.mail.urbanovichalexandr.servises.ICoursServiсes;

public class CoursServicesTest extends AbstractTest{
	
private static final Logger LOGGER = LoggerFactory.getLogger(CoursServicesTest.class);
	
	@Inject
    private ICoursServiсes service;
	
	@Test
    public void createTest() {
		
		Cours cours = new Cours();
		cours.setNameCours("Matan");
		service.save(cours);
		
		LOGGER.info("Test cours created");
		System.out.println("Saved cours: " + cours);
      
		
		System.out.println(service.gelAll());
		LOGGER.info("Test cours getAll");
        
        Integer savedCoursId = cours.getCoursId();
        Cours coursFromDb = service.get(savedCoursId);
        
        System.out.println(coursFromDb);
        
        
        service.delete(cours.getCoursId());
		LOGGER.info("Test cours deleted");
		

	}
}
