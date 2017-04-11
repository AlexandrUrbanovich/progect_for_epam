package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.datamodel.Cours;
import ru.mail.urbanovichalexandr.servises.ICoursServiсes;

public class CoursServiceTestDelete extends AbstractTest {
private static final Logger LOGGER = LoggerFactory.getLogger(CoursServiceTestDelete.class);
	
	@Inject
    private ICoursServiсes service;
	
	@Test
    public void createTest() {
		
		Cours cours = new Cours();
		
		service.delete(cours.getCoursId());
		LOGGER.info("Test cours deleted");
		
	}
}
