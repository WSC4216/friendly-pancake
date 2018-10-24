package album.service.impl;
import java.util.List;

import album.dao.AlbumDao;
import album.dao.PhotoDao;
import album.dao.UserDao;
import album.domain.Album;
import album.domain.Photo;
import album.domain.User;
import album.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	private AlbumDao albumDao;
	private PhotoDao photoDao;

	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setPhotoDao(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}

	@Override
	public Boolean validLogin(User user) {
		// TODO Auto-generated method stub
		if(userDao.findByUser_nameAndPwd(user)!=null)
			return true;
		else return false;
	}

	@Override
	public List<Album> getAlbums(String user_name) {
		// TODO Auto-generated method stub
		return albumDao.findByUser_name(user_name);
	}

	@Override
	public void addPhoto(Photo photo) {
		// TODO Auto-generated method stub
		photoDao.save(photo);
	}

	@Override
	public List<Photo> getPhotos(int album_id) {
		// TODO Auto-generated method stub
		return photoDao.findByAlbum_id(album_id);	
	}
	
}
