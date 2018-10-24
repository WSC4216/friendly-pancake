package album.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="photo")
public class Photo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String photo_name;
	private String path;
	private Integer album_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(Integer album_id) {
		this.album_id = album_id;
	}
	
	public Photo() {

	}
	public Photo(String photo_name, String path, Integer album_id) {
		super();
		this.photo_name = photo_name;
		this.path = path;
		this.album_id = album_id;
	}
	
	
}
