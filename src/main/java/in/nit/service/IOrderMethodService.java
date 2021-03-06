package in.nit.service;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodService {

	Integer saveOrderMethod(OrderMethod ob);
	List<OrderMethod> getAllOrderMethods();
	void removeOrderMethod(Integer id);
	OrderMethod getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethod ob);
	
	List<Object[]> getOrderMethodOrderTypeCount();
	
	List<Object[]> getOrderIdAndOrderCode(String orderMode);

	boolean isOrderCodeExist(String orderCode);

}
