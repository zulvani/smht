package org.zulvani.smht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zulvani.smht.dao.UserAccountDao;
import org.zulvani.smht.db.Param;
import org.zulvani.smht.domain.UserAccounts;

@Service("authManagerService")
@Transactional(readOnly = true)
public class AuthManagerServiceImpl implements AuthManagerService {

	@Autowired
	private UserAccountDao userAccountDao;

	@Override
	public UserAccounts createUserAccount(UserAccounts domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccounts createOrUpdateUserAccount(UserAccounts domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllUserAccounts() {
		// TODO Auto-generated method stub

	}

	@Override
	public UserAccounts deleteUserAccount(UserAccounts domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccounts> findAllUserAccounts() {
		return userAccountDao.readAll();
	}

	@Override
	public List<UserAccounts> findAllUserAccounts(int start, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccounts> findAllUserAccounts(Param... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAccounts> findAllUserAccounts(int start, int num,
			Param... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccounts findUserAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAllUserAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countAllUserAccounts(Param... params) {
		// TODO Auto-generated method stub
		return 0;
	}

}