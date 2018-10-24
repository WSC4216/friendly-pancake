package album.action;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import album.domain.Photo;
import album.service.UserService;

public class UploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7376383182998204499L;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private int album_id;
	private UserService userService;
	
	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String upload() {
		String t=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		ActionContext ctx = ActionContext.getContext();
		String user_name=(String)ctx.getSession().get("user_name");
		int num=t.indexOf(".metadata");
		String path=t.substring(1,num).replace('/', '\\')+"album\\WebContent\\WEB-INF\\user\\"+user_name;
		String fileName="";
		try {
			fileName = new String(uploadFileName.getBytes("gbk"), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setSavePath(path+File.separator+fileName);
		System.out.println(getSavePath()+"路径");
		try {
			FileOutputStream fos=new FileOutputStream(savePath);
			FileInputStream fis=new FileInputStream(upload);
			byte[] buffer=new byte[1024];
			int len=0;
			while((len=fis.read(buffer))>0) {
				fos.write(buffer,0,len);
			}
			fos.flush();
			fis.close();
			fos.close();
			Photo photo=new Photo(fileName, savePath, album_id);
			userService.addPhoto(photo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return SUCCESS;
		
	}
	
}
