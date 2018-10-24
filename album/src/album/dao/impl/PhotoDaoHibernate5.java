package album.dao.impl;

import java.util.List;

import album.dao.PhotoDao;
import album.domain.Photo;
import common.dao.impl.BaseDaoHibernate5;

public class PhotoDaoHibernate5 extends BaseDaoHibernate5<Photo> implements PhotoDao {

	@Override
	public List<Photo> findByAlbum_id(int album_id) {
		return find("select p from Photo p where p.album_id=?0",album_id);
	}

}
