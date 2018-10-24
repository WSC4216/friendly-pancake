package album.dao.impl;

import album.dao.UserDao;
import album.domain.User;
import common.dao.impl.BaseDaoHibernate5;

public class UserDaoHibernate5 extends BaseDaoHibernate5<User> implements UserDao {

	@Override
	public User findByUser_nameAndPwd(User user) {
		// TODO Auto-generated method stub
		return find("select u from User u where user_name=?0 and pwd=?1",user.getUser_name(),user.getPwd()).get(0);
	}

}
