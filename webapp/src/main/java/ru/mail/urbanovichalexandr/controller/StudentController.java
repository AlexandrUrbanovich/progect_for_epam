package ru.mail.urbanovichalexandr.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.models.StudentModel;
import ru.mail.urbanovichalexandr.servises.IStudentServices;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Inject
	private IStudentServices studentService;
	
	@RequestMapping(value = "/{student_id}",method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(value = "student_id") Integer studentId) {
		Student student = studentService.get(studentId);
		StudentModel studentModel = entity2model(student);
		return new ResponseEntity<StudentModel>(studentModel, HttpStatus.OK);
	}
	
	 private StudentModel entity2model(Student student) {
		 	StudentModel studentModel = new StudentModel();
		 	studentModel.setFirstName(student.getFirstName());
		 	studentModel.setLastName(student.getLastName());
		 	studentModel.setKurs(student.getKurs());
	        return studentModel;
	    }
}
