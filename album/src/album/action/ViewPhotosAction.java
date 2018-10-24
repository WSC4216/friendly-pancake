package album.action;

import java.util.List;
import album.domain.Photo;

public class ViewPhotosAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	private int album_id;
	private List<Photo> photos;
	
		public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	@Override
	public String execute() {
		setPhotos(userService.getPhotos(getAlbum_id()));
		return SUCCESS;
	}
}
