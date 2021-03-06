package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.mail.urbanovichalexandr.datamodel.User;
import ru.mail.urbanovichalexandr.servises.IUserServices;

public class UserServicesTest extends AbstractTest{
private static final Logger LOGGER = LoggerFactory.getLogger(UserServicesTest.class);
	
	@Inject
	private IUserServices service;
	
	@Test
	public void createTest(){
		User user = new User();
		user.setLogin("QQQ");
		user.setPassword(1234);
		service.save(user);
		
		LOGGER.info("Test user created");

		System.out.println("Saved user: " + user);
		System.out.println(service.get(user.getUserId()));
		
		
		System.out.println(service.getAll());
    	LOGGER.info("Test user getAll");
    	
    	
    	service.delete(user.getUserId());
		LOGGER.info("Test user deleted");
	}
}
