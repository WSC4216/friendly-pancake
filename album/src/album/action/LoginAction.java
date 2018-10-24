package album.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import album.domain.Album;
import album.domain.User;
import album.service.UserService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private User user;
	private String vercode;
	private UserService userService;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getVercode() {
		return vercode;
	}
	public void setVercode(String vercode) {
		this.vercode = vercode;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String login() {
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的rand属性
		String ver2 = (String) ctx.getSession().get("rand");
		if (vercode.equalsIgnoreCase(ver2)) {
			if (userService.validLogin(getUser())) {
				ctx.getSession().put("user_name", user.getUser_name());
				List<Album> albums=userService.getAlbums(user.getUser_name()); 
				System.out.println(albums);
				ctx.getSession().put("albums", albums);
				return SUCCESS;
			}
			return LOGIN;
		}
		addActionMessage("验证码不匹配,请重新输入");
		return ERROR;
	}
	
}
