package ru.mail.urbanovichalexandr.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.mail.urbanovichalexandr.datamodel.Cours;
import ru.mail.urbanovichalexandr.models.CoursModel;
import ru.mail.urbanovichalexandr.models.IdModel;
import ru.mail.urbanovichalexandr.servises.ICoursServiсes;

@RestController
@RequestMapping("/cours")
public class CoursController {

	@Inject
	private ICoursServiсes coursServiсes;

	@RequestMapping(value = "/{cours_id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(value = "cours_id") Integer coursId) {
		Cours cours = coursServiсes.get(coursId);
		CoursModel coursModel = entity2model(cours);
		return new ResponseEntity<CoursModel>(coursModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createCours(@RequestBody CoursModel coursModel) {
		Cours cours = model2entity(coursModel);
		coursServiсes.save(cours);
		return new ResponseEntity<IdModel>(new IdModel(cours.getCoursId()), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCours(@RequestBody CoursModel coursModel,
			@PathVariable(value = "id") Integer CoursIdParam) {
		Cours cours = coursServiсes.get(CoursIdParam);
		cours.setNameCours(cours.getNameCours());
		coursServiсes.save(cours);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCours(@PathVariable(value = "id") Integer CoursIdParam) {
		coursServiсes.delete(CoursIdParam);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}

	private CoursModel entity2model(Cours cours) {
		CoursModel coursModel = new CoursModel();
		coursModel.setNameCours(cours.getNameCours());
		return coursModel;
	}

	private Cours model2entity(CoursModel coursModel) {
		Cours cours = new Cours();
		cours.setNameCours(cours.getNameCours());
		return cours;
	}
}
