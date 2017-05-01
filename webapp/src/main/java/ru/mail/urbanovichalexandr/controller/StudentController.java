package ru.mail.urbanovichalexandr.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.models.IdModel;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createStudent(@RequestBody StudentModel studentModel){
		Student student = model2entity(studentModel); 
		studentService.save(student);
		return new ResponseEntity<IdModel>(new IdModel(student.getStudentId()), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@RequestBody StudentModel studentModel, @PathVariable(value = "id") Integer StudentIdParam){
		Student student = studentService.get(StudentIdParam);
		student.setFirstName(studentModel.getFirstName());
		student.setLastName(studentModel.getLastName());
		student.setKurs(studentModel.getKurs());
		studentService.save(student);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStudente( @PathVariable(value = "id") Integer StudentIdParam){
		studentService.delete(StudentIdParam);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
		
	}
	
	
	 private StudentModel entity2model(Student student) {
		 	StudentModel studentModel = new StudentModel();
		 	studentModel.setFirstName(student.getFirstName());
		 	studentModel.setLastName(student.getLastName());
		 	studentModel.setKurs(student.getKurs());
	        return studentModel;
	    }
	 
	 private Student model2entity(StudentModel studentModel){
		 Student student = new Student();
		 student.setFirstName(studentModel.getFirstName());
		 student.setLastName(studentModel.getLastName());
		 student.setKurs(studentModel.getKurs());
		 return student;
	 }
}
