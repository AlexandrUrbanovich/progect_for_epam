package ru.mail.urbanovichalexandr.dao.impl.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.mail.urbanovichalexandr.datamodel.Cours;
import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.datamodel.StudentCourses;

public class StudentWithCoursMapper implements RowMapper<StudentCourses> {

	@Override
	public StudentCourses mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student();
		student.setFirstName(rs.getString("firstname"));
		student.setLastName(rs.getString("lastname"));
		student.setKurs(rs.getInt("kurs"));
		
		Cours cours = new Cours();
		cours.setNameCours(rs.getString("name_cours"));
		
		StudentCourses studentCourses = new StudentCourses();
		studentCourses.setStudent(student);
		studentCourses.setCours(cours);
		
		return studentCourses;
	}

}
