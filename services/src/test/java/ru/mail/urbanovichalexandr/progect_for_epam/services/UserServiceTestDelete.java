package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.datamodel.User;
import ru.mail.urbanovichalexandr.servises.IUserServices;

public class UserServiceTestDelete extends AbstractTest{
	
private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTestDelete.class);
	
	@Inject
	private IUserServices service;
	
	@Test
	public void createTest(){
		User user = new User();
		
		service.delete(user.getUserId());
		LOGGER.info("Test user deleted");
	}
}
