package cn.app.po;

import java.util.List;


//Description:包装类型 

public class UserQueryVo {
	
	//传入多个id
	private List<Integer> ids;
	
	
	//在这里包装所�?��的查询条�?
	
	//用户查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	//可以包装其它的查询条件，订单、商�?
	//....
	

}
