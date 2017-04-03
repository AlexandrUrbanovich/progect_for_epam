package ru.mail.urbanovichalexandr.servises;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.mail.urbanovichalexandr.datamodel.User;

public interface IUserServices {

	User get(Integer userId);

	@Transactional
	void save(User user);

	@Transactional
	void saveMultiple(User... user);

	List<User> getAll();

	@Transactional
	void delete(Integer userId);
}
