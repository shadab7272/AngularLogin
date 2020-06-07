package com.dbs.login.nonperfaccount.entity;

import javax.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "EXCLUSION_ACCOUNTS")
public class NonPerformingAccount {

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
	private long id;
    
    @Column(name = "ACCOUNT_NUMBER")
	private String accountid;
}
