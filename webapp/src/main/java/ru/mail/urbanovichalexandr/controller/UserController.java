package ru.mail.urbanovichalexandr.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.mail.urbanovichalexandr.datamodel.User;
import ru.mail.urbanovichalexandr.models.IdModel;
import ru.mail.urbanovichalexandr.models.UserModel;
import ru.mail.urbanovichalexandr.servises.IUserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Inject
	private IUserServices userServices;
	
	@RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(value = "user_id") Integer userId){
		User user = userServices.get(userId);
		UserModel userModel = entity2model(user);
		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
		User user = model2entity(userModel);
		userServices.save(user);
		return new ResponseEntity<IdModel>(new IdModel(user.getStudentId()), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UserModel userModel, @PathVariable(value = "id") Integer UserIdParam) {
		User user = userServices.get(UserIdParam);
		user.setLogin(userModel.getLogin());
		user.setPassword(userModel.getPassword());
		user.setRole(userModel.getRole());
		userServices.save(user);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer UserIdParam) {
		userServices.delete(UserIdParam);
		return new ResponseEntity<IdModel>(HttpStatus.OK);
	}
	
	private UserModel entity2model(User user) {
		UserModel userModel = new UserModel();
		userModel.setLogin(user.getLogin());
		userModel.setPassword(user.getPassword());
		userModel.setRole(user.getRole());
		return userModel;
	}
	
	private User model2entity (UserModel userModel){
		User user = new User();
		user.setLogin(userModel.getLogin());
		user.setPassword(userModel.getPassword());
		user.setRole(userModel.getRole());
		return user;
	}

}