package org.zulvani.smht.service;

import java.util.List;

import org.zulvani.smht.db.Param;
import org.zulvani.smht.domain.UserAccounts;

public interface AuthManagerService {

	public UserAccounts createUserAccount(UserAccounts domain);

	public UserAccounts createOrUpdateUserAccount(UserAccounts domain);

	public void deleteAllUserAccounts();

	public UserAccounts deleteUserAccount(UserAccounts domain);

	public List<UserAccounts> findAllUserAccounts();

	public List<UserAccounts> findAllUserAccounts(int start, int num);

	public List<UserAccounts> findAllUserAccounts(Param... params);

	public List<UserAccounts> findAllUserAccounts(int start, int num,
			Param... params);

	public UserAccounts findUserAccountById(int id);

	public int countAllUserAccounts();

	public int countAllUserAccounts(Param... params);
}