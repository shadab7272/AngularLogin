package com.dbs.login.nonperfaccount.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.login.nonperfaccount.entity.UsersList;


@Repository
public interface UserListJPARepo extends JpaRepository<UsersList, Long> {

	List<UsersList> findByUsernameAndPassword(String username, String password);
	
	UsersList findByKey(String key);

}
