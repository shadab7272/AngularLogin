package com.dbs.login.nonperfaccount.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.login.nonperfaccount.entity.NonPerformingAccount;


@Repository
public interface NonPerformingAccountJPARepo extends
		JpaRepository<NonPerformingAccount, Long> {

}
