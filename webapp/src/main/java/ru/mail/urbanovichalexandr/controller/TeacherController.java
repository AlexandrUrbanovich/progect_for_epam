package ru.mail.urbanovichalexandr.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.mail.urbanovichalexandr.datamodel.Teacher;
import ru.mail.urbanovichalexandr.models.IdModel;
import ru.mail.urbanovichalexandr.models.TeacherModel;
import ru.mail.urbanovichalexandr.servises.ITeacherServices;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Inject
	private ITeacherServices teacherServices;

	@RequestMapping(value = "{teacher_id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(value = "teacher_id") Integer teacherId) {
		Teacher teacher = teacherServices.get(teacherId);
		TeacherModel teacherModel = entity2model(teacher);
		return new ResponseEntity<TeacherModel>(teacherModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createTeacher(@RequestBody TeacherModel teacherModel) {
		Teacher teacher = model2entity(teacherModel);
		teacherServices.save(teacher);
		return new ResponseEntity<IdModel>(new IdModel(teacher.getTeacherId()), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTeacher(@RequestBody TeacherModel teacherModel,
			@PathVariable(value = "id") Integer TeacherIdParam) {
		Teacher teacher = teacherServices.get(TeacherIdParam);
		teacher.setFirstname(teacherModel.getFirstname());
		teacher.setLastname(teacherModel.getLastname());
		teacherServices.save(teacher);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTeacher(@PathVariable(value = "id") Integer TeacherIdParam) {
		teacherServices.delete(TeacherIdParam);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}

	private TeacherModel entity2model(Teacher teacher) {
		TeacherModel teacherModel = new TeacherModel();
		teacherModel.setFirstname(teacher.getFirstname());
		teacherModel.setLastname(teacher.getLastname());
		return teacherModel;
	}

	private Teacher model2entity(TeacherModel teacherModel) {
		Teacher teacher = new Teacher();
		teacher.setFirstname(teacherModel.getFirstname());
		teacher.setLastname(teacherModel.getLastname());
		return teacher;
	}
}
