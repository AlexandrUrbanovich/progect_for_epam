package ru.mail.urbanovichalexandr.dao.impl.db.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import ru.mail.urbanovichalexandr.dao.impl.db.IStudentCoursesDao;
import ru.mail.urbanovichalexandr.dao.impl.db.mapper.StudentWithCoursMapper;
import ru.mail.urbanovichalexandr.datamodel.End;
import ru.mail.urbanovichalexandr.datamodel.StudentCourses;

public class StudentCoursesDaoImpl implements IStudentCoursesDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public StudentCourses get(Integer studentId) {
		try {
			return jdbcTemplate.queryForObject("select * from student_courses where student_id = ? ", new Object[] { studentId },
					new BeanPropertyRowMapper<StudentCourses>(StudentCourses.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void update(StudentCourses studentCourses) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentCourses> getAll() {
		List<StudentCourses> rs = jdbcTemplate.query("select * from student_courses ", new BeanPropertyRowMapper<StudentCourses>(StudentCourses.class));
	    return rs;
	}

	@Override
	public void delete(Integer studentId) {
		jdbcTemplate.update("delete from student_courses where student_id =" + studentId);
	}

	@Override
	public StudentCourses getStudentWithCours(Integer studentId) {
		return jdbcTemplate.queryForObject("select * from student_courses a" + "right join students c on a.student_id = c.student_id" +
				"where student_id = ?",
				new Object[] {studentId}, new StudentWithCoursMapper());
	}

	@Override
	public void insert(StudentCourses student) {
		// TODO Auto-generated method stub
		
	}
	
}
