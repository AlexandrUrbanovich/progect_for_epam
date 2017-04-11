package ru.mail.urbanovichalexandr.dao.impl.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ru.mail.urbanovichalexandr.dao.api.IStudentDao;
import ru.mail.urbanovichalexandr.datamodel.Student;


@Repository
public class StudentDaoImpl implements IStudentDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Student get(Integer studentId) {
		try {
			return jdbcTemplate.queryForObject("select * from students where student_id = ? ",
					new Object[] { studentId }, new BeanPropertyRowMapper<Student>(Student.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
 
	@Override
	public Student insert(Student entity) {
		final String INSERT_SQL = "insert into students (firstName, lastName, kurs) values(?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "student_id" });
				ps.setString(1, entity.getFirstName());
				ps.setString(2, entity.getLastName());
				ps.setInt(3, entity.getKurs());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		entity.setStudentId(key.intValue());
		return entity;
	}

	@Override
	public List<Student> getAll() {
		 List<Student> rs = jdbcTemplate.query("select * from students ", new BeanPropertyRowMapper<Student>(Student.class));
	     return rs;
	}

	@Override
	public void delete(Integer studentId) {
		jdbcTemplate.update("delete from students where student_id =" + studentId);
	}

	@Override
	public void update(Student student) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement("firstname=?, lastname=?, kurs=?"); 
				ps.setString(1,student.getFirstName());
				ps.setString(2, student.getLastName());
				ps.setInt(3, student.getKurs());
				
				return ps;
			}
		});		
	}
}
