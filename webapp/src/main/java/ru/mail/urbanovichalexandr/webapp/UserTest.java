package ru.mail.urbanovichalexandr.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.mail.urbanovichalexandr.datamodel.User;
import ru.mail.urbanovichalexandr.datamodel.enu.UserRole;
import ru.mail.urbanovichalexandr.servises.IUserServices;


public class UserTest {

	public static void main(String[] args){
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

	        IUserServices service = context.getBean(IUserServices.class);
	        
	        User user = new User();
	        user.setLogin("QQQ");
	        user.setPassword(1234);
	        user.setRole(UserRole.teacher);
	        service.save(user);

	        System.out.println("Saved user: " + user);
	        System.out.println(service.get(user.getUserId()));
	        
	        service.delete(user.getUserId());
	        
	        System.out.println(service.get(user.getUserId()));
	}       
}
