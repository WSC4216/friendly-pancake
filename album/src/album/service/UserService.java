package album.service;

import java.util.List;
import album.domain.Album;
import album.domain.Photo;
import album.domain.User;

public interface UserService {
	
	Boolean validLogin(User user);
	List<Album> getAlbums(String user_name);
	void addPhoto(Photo photo);
	List<Photo> getPhotos(int album_id);
}
