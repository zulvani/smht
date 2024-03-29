package org.zulvani.smht.domain;

// default package
// Generated Sep 3, 2014 6:20:52 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UserAccounts generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "user_accounts", catalog = "smht", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class UserAccounts implements java.io.Serializable {

	private int id;
	private String username;
	private String password;

	public UserAccounts() {
	}

	public UserAccounts(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username", unique = true, nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
