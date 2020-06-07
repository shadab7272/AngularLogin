package com.dbs.login.nonperfaccount.controller;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dbs.login.nonperfaccount.entity.LoginData;
import com.dbs.login.nonperfaccount.entity.NonPerformingAccount;
import com.dbs.login.nonperfaccount.repo.LoginDataJPARepo;
import com.dbs.login.nonperfaccount.repo.NonPerformingAccountJPARepo;


@RestController
@CrossOrigin
public class SubmitController {

	@Autowired
	private NonPerformingAccountJPARepo nonPerformingAccountJPARepo;

	@Autowired
	private LoginDataJPARepo loginDataJPARepo;

	@GetMapping("/getAllNonPerfAccount")
	public List<NonPerformingAccount> getAllAccount() {
		return nonPerformingAccountJPARepo.findAll();
	}

	@PostMapping("/saveNonPerfAccount")
	public NonPerformingAccount saveAccount(@RequestBody NonPerformingAccount nonPerformingAccount) {
		return nonPerformingAccountJPARepo.save(nonPerformingAccount);
	}

	@GetMapping("/getAllLoginData")
	public List<LoginData> getAllLoginData(@RequestParam(value = "role") String role) {
		if (role != "" && role.equals("admin")) {
			return loginDataJPARepo.findByStatusNot("cancelled");
		}
		return loginDataJPARepo.findAll();
	}

	@PostMapping("/saveUserNonPerfAccount")
	public void saveLoginData(@RequestBody LoginData loginData) {
		loginData.setSubmittedDate(new Date(System.currentTimeMillis()));
		loginDataJPARepo.save(loginData);
	}

	@PostMapping("/accountAction")
	public void accountAction(@RequestBody LoginData loginData) {
		LoginData userRequestEntity = loginDataJPARepo.findByRequestId((Long) loginData.getRequestId());
		userRequestEntity.setApprovalDate(new Date(System.currentTimeMillis()));
		userRequestEntity.setApprovedBy(loginData.getApprovedBy());
		userRequestEntity.setStatus(loginData.getStatus());
		loginDataJPARepo.save(userRequestEntity);
	}

	@Autowired
	@DeleteMapping("/deleteAccount")
	public void deleteAccount(@RequestParam(value = "id") long id) {
		loginDataJPARepo.deleteById(id);
	}


}
