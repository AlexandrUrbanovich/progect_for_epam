package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.servises.ICoursServiсes;

public class CoursServicesTestGet extends AbstractTest{
	
private static final Logger LOGGER = LoggerFactory.getLogger(CoursServicesTestGet.class);
	
	@Inject
    private ICoursServiсes service;
	
	@Test
    public void createTest() {
		
		System.out.println(service.gelAll());
		LOGGER.info("Test cours getAll");

	}
}
