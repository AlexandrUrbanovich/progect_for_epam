package ru.mail.urbanovichalexandr.dao.impl.db;

import java.util.List;

import ru.mail.urbanovichalexandr.datamodel.User;

public interface IUserDao {
	
	User get(Integer userId);
	
	User insert(User user);
	
	void update(User user);
	
	List<User> getAll();
	
	void delete(Integer userId);

}
