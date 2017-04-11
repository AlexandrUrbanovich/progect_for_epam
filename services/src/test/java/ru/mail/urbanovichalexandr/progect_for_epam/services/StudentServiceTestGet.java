package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.servises.IStudentServices;

public class StudentServiceTestGet extends AbstractTest {
	
private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceTestGet.class);
	
	@Inject
    private IStudentServices service;

    @Test
    public void createTest() {
    	
    	System.out.println(service.getAll());
    	LOGGER.info("Test student getAll");
    }

}
