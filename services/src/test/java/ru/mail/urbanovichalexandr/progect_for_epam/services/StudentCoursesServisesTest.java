package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;

import ru.mail.urbanovichalexandr.datamodel.StudentCourses;
import ru.mail.urbanovichalexandr.servises.IStudentCoursesServices;


public class StudentCoursesServisesTest extends AbstractTest{
	
	@Inject
    private IStudentCoursesServices service;
	
	@Test
    public void createTest() {
		
		StudentCourses studentCourses = new StudentCourses();
		
        System.out.println(service.get(studentCourses.getStudentId()));
	}
}
