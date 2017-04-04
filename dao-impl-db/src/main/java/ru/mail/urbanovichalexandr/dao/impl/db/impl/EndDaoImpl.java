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

import ru.mail.urbanovichalexandr.dao.impl.db.IEndDao;
import ru.mail.urbanovichalexandr.datamodel.End;

public class EndDaoImpl implements IEndDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public End get(Integer endId) {
		try {
			return jdbcTemplate.queryForObject("select * from end where end_id = ? ", new Object[] { endId },
					new BeanPropertyRowMapper<End>(End.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public End insert(End entity) {
		final String INSERT_SQL = "insert into end (mark, text) values(?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "end_id" });
                ps.setInt(1, entity.getMark());
                ps.setString(2, entity.getText());
                return ps;
            }
        }, keyHolder);

        Number key = keyHolder.getKey();
        entity.setStudentId(key.intValue());
        return entity;
	}

	@Override
	public void update(End end) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<End> getAll() {
		List<End> rs = jdbcTemplate.query("select * from end ", new BeanPropertyRowMapper<End>(End.class));
	    return rs;
	}

	@Override
	public void delete(Integer studentId) {
		jdbcTemplate.update("delete from end where student_id =" + studentId);
	}

}
