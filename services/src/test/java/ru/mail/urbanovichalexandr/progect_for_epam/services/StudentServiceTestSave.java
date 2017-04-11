package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.servises.IStudentServices;

public class StudentServiceTestSave extends AbstractTest{
	
private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceTestSave.class);
	
	@Inject
    private IStudentServices service;

    @Test
    public void createTest() {
    	Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");
        student.setKurs(2);
        service.save(student);

        LOGGER.info("Test student created");
        
        System.out.println("Saved student: " + student);
    }
}
