package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.datamodel.Teacher;
import ru.mail.urbanovichalexandr.servises.ITeacherServices;

public class TeacherServicesTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServicesTest.class);

	@Inject
	private ITeacherServices service;

	@Test
	public void createTest() {
		Teacher teacher = new Teacher();
		teacher.setFirstname("Petrov");
		teacher.setLastname("Petr");
		service.save(teacher);
		
		LOGGER.info("Test teacher created");

		System.out.println("Saved teacher: " + teacher);
		System.out.println(service.get(teacher.getTeacherId()));

		service.delete(teacher.getTeacherId());
		LOGGER.info("Test teacher deleted");

		System.out.println(service.get(teacher.getTeacherId()));

	}
}