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

import ru.mail.urbanovichalexandr.dao.impl.db.IUserDao;
import ru.mail.urbanovichalexandr.datamodel.Student;
import ru.mail.urbanovichalexandr.datamodel.User;

public class UserDaoImpl implements IUserDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public User get(Integer userId) {
		try {
			return jdbcTemplate.queryForObject("select * from users where user_id = ? ", new Object[] { userId },
					new BeanPropertyRowMapper<User>(User.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public User insert(User entity) {
		final String INSERT_SQL = "insert into users (login, password, role) values(?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "user_id" });
				ps.setString(1, entity.getLogin());
				ps.setInt(2, entity.getPassword());
				ps.setString(3, entity.getRole().name());
				return ps;
			}
		}, keyHolder);

		Number key = keyHolder.getKey();
		entity.setUserId(key.intValue());
		return entity;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		List<User> rs = jdbcTemplate.query("select * from users ", new BeanPropertyRowMapper<User>(User.class));
	    return rs;
	}

	@Override
	public void delete(User userId) {
		jdbcTemplate.update("delete from users where user_id =" + userId);
		
	}

}
