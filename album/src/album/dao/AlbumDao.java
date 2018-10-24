package album.dao;

import java.util.List;

import album.domain.Album;
import common.dao.BaseDao;

public interface AlbumDao extends BaseDao<Album>{
	List<Album> findByUser_name(String user_name);
}
