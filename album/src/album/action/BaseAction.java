package album.action;

import com.opensymphony.xwork2.ActionSupport;

import album.service.UserService;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	protected UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
