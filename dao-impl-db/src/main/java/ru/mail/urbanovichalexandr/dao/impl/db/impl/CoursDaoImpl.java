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

import ru.mail.urbanovichalexandr.dao.api.ICoursDao;
import ru.mail.urbanovichalexandr.datamodel.Cours;

@Repository
public class CoursDaoImpl implements ICoursDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Cours get(Integer coursId) {
		try {
            return jdbcTemplate.queryForObject("select a.name_cours, b.firstname, b.lastname " + 
            		"from courses a left join teachers b on a.teacher_id = b.teacher_id where cours_id = ? ", 
            		new Object[] { coursId }, new BeanPropertyRowMapper<Cours>(Cours.class));
        	} catch (EmptyResultDataAccessException e) {
            return null;
        }
	}

	@Override
	public Cours insert(Cours entity) {
		final String INSERT_SQL = "insert into courses (name_cours) values(?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "cours_id" });
                ps.setString(1, entity.getNameCours());
                return ps;
            }
        }, keyHolder);

        Number key = keyHolder.getKey();
        entity.setCoursId(key.intValue());
        return entity;
	}

	@Override
	public void update(Cours cours) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement("name_cours=?"); 
				ps.setString(1, cours.getNameCours());
				
				return ps;
			}
		});
	}

	@Override
	public List<Cours> getAll() {
		 List<Cours> rs = jdbcTemplate.query("select a.name_cours, b.firstname, b.lastname " +
				 "from courses a left join teachers b on a.teacher_id = b.teacher_id", 
            		new BeanPropertyRowMapper<Cours>(Cours.class));
	     return rs;
	}

	@Override
	public void delete(Integer coursId) {
		jdbcTemplate.update("delete from students where student_id =" + coursId);
	}


}
