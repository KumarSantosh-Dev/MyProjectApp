package in.nit.dao;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodDao {

	Integer saveOrderMethod(OrderMethod ob);
	List<OrderMethod> getAllOrderMethods();
	void removeOrderMethod(Integer id);
	OrderMethod getOneOrderMethod(Integer id);
	void updateOrderMethod(OrderMethod ob);
	
	List<Object[]> getOrderMethodOrderTypeCount();
}
