package ru.mail.urbanovichalexandr.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.servises.IStudentServices;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Inject
	private IStudentServices studentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getStudent(Model model){
		
		List<Student> allStudent = this.studentService.getAll();
		
		model.addAttribute(allStudent);
		
		
		return "index";
	}
}
