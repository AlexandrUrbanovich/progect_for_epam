package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;

import ru.mail.urbanovichalexandr.datamodel.Teacher;
import ru.mail.urbanovichalexandr.servises.ITeacherServices;

public class TeacherServicesTest extends AbstractTest {
	
	@Inject
	private ITeacherServices service;
	
	@Test
	public void createTest(){
		Teacher teacher = new Teacher();
		teacher.setFirstname("Petrov");
		teacher.setLastname("Petr");
		service.save(teacher);
		
		 System.out.println("Saved teacher: " + teacher);
	     System.out.println(service.get(teacher.getTeacherId()));
	        
	     service.delete(teacher.getTeacherId());
	        
	     System.out.println(service.get(teacher.getTeacherId()));
		
	}
}