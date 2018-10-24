package album.dao;

import album.domain.User;
import common.dao.BaseDao;

public interface UserDao extends BaseDao<User> {
	User findByUser_nameAndPwd(User user);
}
