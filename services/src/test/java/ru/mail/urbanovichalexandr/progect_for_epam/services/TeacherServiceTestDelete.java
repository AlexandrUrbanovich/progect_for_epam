package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.datamodel.Teacher;
import ru.mail.urbanovichalexandr.servises.ITeacherServices;

public class TeacherServiceTestDelete extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceTestDelete.class);

	@Inject
	private ITeacherServices service;

	@Test
	public void createTest() {
		Teacher teacher = new Teacher();

		service.delete(teacher.getTeacherId());
		LOGGER.info("Test teacher deleted");
		
	}

}
