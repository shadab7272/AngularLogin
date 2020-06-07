package com.dbs.login.nonperfaccount.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.login.nonperfaccount.entity.User;
import com.dbs.login.nonperfaccount.entity.UsersList;
import com.dbs.login.nonperfaccount.repo.UserListJPARepo;


@RestController
@CrossOrigin
public class UserLoginController {

	@Autowired
    private UserListJPARepo userListJPARepo;
	
	@GetMapping("/login")
	public User login(@RequestParam(value="username") String username,@RequestParam(value="password") String password) {
		UsersList usersList = null;
		User userResp = null;
		if(null != username && username.length() > 0 ){
			List<UsersList> users = userListJPARepo.findByUsernameAndPassword(username, password);
			if(users.size()>0){
				userResp = new User();
				userResp.setUsername(users.get(0).getUsername());
				userResp.setRole(users.get(0).getRole());
				String key = users.get(0).getUsername()+ new Date().toString();
				userResp.setKey(key);
				UsersList keySessionUser = users.get(0);
				keySessionUser.setKey(key);
				usersList = userListJPARepo.save(keySessionUser);
				userResp = new User();
				userResp.setUsername(usersList.getUsername());
				userResp.setRole(usersList.getRole());
				userResp.setKey(usersList.getKey());
				return userResp;
			}
		}
		return userResp;
	}
	
	@GetMapping("/logout")
	public UsersList logout(@RequestParam(value="key") String key) {
		userListJPARepo.findByKey(key);
		return null;
	}
	
	
	
}
