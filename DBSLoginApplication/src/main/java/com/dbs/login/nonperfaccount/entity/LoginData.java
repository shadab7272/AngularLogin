package com.dbs.login.nonperfaccount.entity;

import java.sql.Date;

import javax.persistence.*;
import lombok.Data;



@Entity
@Table(name = "LOGIN_DATA")
public class LoginData {
	private long requestId;
	private String submittedBy;
	private Date submittedDate;
	private String approvedBy;
	private Date approvalDate;
	private String status;
	private String accountNumber;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	@Column(name = "SUBMITTED_BY")
	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}

	@Column(name = "SUBMITTED_DATE")
	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	@Column(name = "APPROVED_BY")
	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Column(name = "APPROVAL_DATE")
	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;	
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "ACCOUNT_NUMBER")
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}