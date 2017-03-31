package ru.mail.urbanovichalexandr.webapp;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.servises.IStudentServices;

public class ServiceTest {
	
	public static void main(String[] args){
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");

	        IStudentServices service = context.getBean(IStudentServices.class);

	        Student student = new Student();
	        student.setFirstName("Ivan");
	        student.setLastName("Ivanov");
	        student.setKurs(2);
	        service.save(student);

	        System.out.println("Saved student: " + student);

	        System.out.println(service.get(student.getStudentId()));
	        service.delete(student.getStudentId());
	        System.out.println(service.get(student.getStudentId()));
	}
}