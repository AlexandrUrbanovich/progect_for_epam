package ru.mail.urbanovichalexandr.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ru.mail.urbanovichalexandr.dao.api.IUserDao;
import ru.mail.urbanovichalexandr.datamodel.User;
import ru.mail.urbanovichalexandr.servises.IUserServices;

@Service
public class UserServicesImpl implements IUserServices {
	
	@Inject
	private IUserDao userDao;

	@Override
	public User get(Integer userId) {
		return userDao.get(userId);
	}

	@Override
	public void save(User user) {
		if(user.getUserId()==null){
			System.out.println("Insetr new user");
			userDao.insert(user);
		} else{
			userDao.update(user);
		}
	}

	@Override
	public void saveMultiple(User... userArray) {
		for(User user: userArray){
			save(user);
		}		
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void delete(Integer userId) {
		userDao.delete(userId);
	}
}
