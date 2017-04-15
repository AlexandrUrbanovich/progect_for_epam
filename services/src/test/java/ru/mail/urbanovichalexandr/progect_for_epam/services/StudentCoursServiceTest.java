package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.datamodel.StudentCourses;
import ru.mail.urbanovichalexandr.servises.IStudentCoursesServices;

public class StudentCoursServiceTest extends AbstractTest{
	
private static final Logger LOGGER = LoggerFactory.getLogger(CoursServiceTestDelete.class);
	
	@Inject
    private IStudentCoursesServices service;
	
	@Test
    public void createTest() {
		
		StudentCourses studentCourses = new StudentCourses();
		
		System.out.println(service.getAll());
		
		System.out.println(service.get(studentCourses.getStudentId()));
		LOGGER.info("Test studentCourses get");
	}

}
