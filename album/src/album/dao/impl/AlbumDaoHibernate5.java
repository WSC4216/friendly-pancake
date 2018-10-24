package album.dao.impl;

import java.util.List;

import album.dao.AlbumDao;
import album.domain.Album;
import common.dao.impl.BaseDaoHibernate5;

public class AlbumDaoHibernate5 extends BaseDaoHibernate5<Album> implements AlbumDao {

	@Override
	public List<Album> findByUser_name(String user_name) {
		// TODO Auto-generated method stub
		return find("select a from Album a ,User u where u.user_name=?0 and u.id=a.user_id ", user_name);
	}

}
