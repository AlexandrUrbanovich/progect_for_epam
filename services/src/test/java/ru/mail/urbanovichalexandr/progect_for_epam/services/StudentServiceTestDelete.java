package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.servises.IStudentServices;

public class StudentServiceTestDelete extends AbstractTest{
	
private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceTestDelete.class);
	
	@Inject
    private IStudentServices service;

    @Test
    public void createTest() {
    	Student student = new Student();
    	
        service.delete(student.getStudentId());
        LOGGER.info("Test student deleted");

    }
}
