package cn.app.mapper;

import java.util.List;

import cn.app.po.Orders;
import cn.app.po.OrdersCustom;
import cn.app.po.User;


//Description: 订单mapper</p>

public interface OrdersMapperCustom {
	
	//查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	//查询订单关联查询用户使用resultMap
	public List<Orders> findOrdersUserResultMap()throws Exception;
	//查询订单(关联用户)及订单明�?
	public List<Orders>  findOrdersAndOrderDetailResultMap()throws Exception;
	
	//查询用户购买商品信息
	public List<User>  findUserAndItemsResultMap()throws Exception;
	
	//查询订单关联查询用户，用户信息是延迟加载
	public List<Orders> findOrdersUserLazyLoading()throws Exception;

}
