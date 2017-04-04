package ru.mail.urbanovichalexandr.progect_for_epam.services;

import javax.inject.Inject;

import org.junit.Test;

import ru.mail.urbanovichalexandr.datamodel.Cours;
import ru.mail.urbanovichalexandr.servises.ICoursServiсes;

public class CoursServicesTest extends AbstractTest {
	
	@Inject
    private ICoursServiсes service;
	
	@Test
    public void createTest() {
		
		Cours cours = new Cours();
		cours.setNameCours("Matan");
		service.save(cours);
		
		System.out.println("Saved cours: " + cours);
        System.out.println(service.get(cours.getCoursId()));
	}

}
