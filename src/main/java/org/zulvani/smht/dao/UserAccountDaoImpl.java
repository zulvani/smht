package org.zulvani.smht.dao;

import org.springframework.stereotype.Repository;
import org.zulvani.smht.domain.UserAccounts;

@Repository("userAccountDao")
public class UserAccountDaoImpl extends BaseImplDao<UserAccounts> implements
		UserAccountDao {

}
