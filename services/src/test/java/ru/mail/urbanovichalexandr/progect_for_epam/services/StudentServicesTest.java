package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;

import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.servises.IStudentService;

public class StudentServicesTest extends AbstractTest {
	
	@Inject
    private IStudentService service;

    @Test
    public void createTest() {
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
