package com.dbs.login.nonperfaccount.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.login.nonperfaccount.entity.LoginData;


@Repository
public interface LoginDataJPARepo extends JpaRepository<LoginData, Long> {
	LoginData findByRequestId(Long key);
	List<LoginData> findByStatusNot(String status);
}
