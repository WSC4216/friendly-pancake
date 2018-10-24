package album.dao;

import java.util.List;

import album.domain.Photo;
import common.dao.BaseDao;

public interface PhotoDao extends BaseDao<Photo> {
	List<Photo> findByAlbum_id(int album_id);
}
