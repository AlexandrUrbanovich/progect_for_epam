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

import ru.mail.urbanovichalexandr.dao.api.ITeacherDao;
import ru.mail.urbanovichalexandr.datamodel.Teacher;

@Repository
public class TeacherDaoImpl implements ITeacherDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Teacher get(Integer teacherId) {
		try {
            return jdbcTemplate.queryForObject("select * from teachers where teacher_id = ? ", new Object[] { teacherId },
                    new BeanPropertyRowMapper<Teacher>(Teacher.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	@Override
	public Teacher insert(Teacher entity) {
		final String INSERT_SQL = "insert into teachers (firstname, lastname) values (?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "teacher_id" });
				ps.setString(1, entity.getFirstname());
                ps.setString(2, entity.getLastname());
				return ps;
			}
		}, keyHolder);
		
		Number key = keyHolder.getKey();
        entity.setTeacherId(key.intValue());
		return entity;
	}

	@Override
	public void update(Teacher teacher) {
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement("firstname=?, lastname=?");
				ps.setString(1, teacher.getFirstname());
				ps.setString(2, teacher.getLastname());

				return ps;
			}
		});
	}

	@Override
	public List<Teacher> getAll() {
		List<Teacher> rs = jdbcTemplate.query("select * from teachers", new BeanPropertyRowMapper<Teacher>(Teacher.class));
		return rs;
	}

	@Override
	public void delete(Integer teacherId) {
		jdbcTemplate.update("delete from teachers where teacher_id = " + teacherId);
	}

}
