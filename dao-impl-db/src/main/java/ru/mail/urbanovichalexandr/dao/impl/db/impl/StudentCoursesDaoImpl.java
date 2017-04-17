package ru.mail.urbanovichalexandr.dao.impl.db.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ru.mail.urbanovichalexandr.dao.api.IStudentCoursesDao;
import ru.mail.urbanovichalexandr.dao.impl.db.mapper.StudentWithCoursMapper;
import ru.mail.urbanovichalexandr.datamodel.StudentCourses;

@Repository
public class StudentCoursesDaoImpl implements IStudentCoursesDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public StudentCourses get(Integer studentId) {
		try {
			return jdbcTemplate.queryForObject("select * from student_courses where student_id = ? ", 
					new Object[] { studentId },	new BeanPropertyRowMapper<StudentCourses>(StudentCourses.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void update(StudentCourses studentCourses) {
		
	}

	@Override
	public List<StudentCourses> getAll() {
		List<StudentCourses> rs = jdbcTemplate.query("select * from student_courses ",
				new BeanPropertyRowMapper<StudentCourses>(StudentCourses.class));
	    return rs;
	}

	@Override
	public void delete(Integer studentId) {
		jdbcTemplate.update("delete from student_courses where student_id =" + studentId);
	}

	@Override
	public StudentCourses getStudentWithCours(Integer studentId) {
		return jdbcTemplate.queryForObject("select a.firstname, a.lastname, a.kurs, c.name_cours " +
				"from students a " +
				"inner join student_courses b on a.student_id = b.student_id "+
				"inner join courses c on b.cours_id = c.cours_id " + 
				"where a.student_id = ?", 
				new Object[] {11}, new StudentWithCoursMapper());
	}
	
	// new BeanPropertyRowMapper<StudentCourses>(StudentCourses.class)

	@Override
	public void insert(StudentCourses student) {
		
	}
	
}
