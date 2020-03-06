package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveOrderMethod(OrderMethod ob) {
		return (Integer)ht.save(ob);
	}
	
	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}
	
	@Override
	public void removeOrderMethod(Integer id) {
		ht.delete(new OrderMethod(id));
	}
	
	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		return ht.get(OrderMethod.class, id);
	}
	
	
	@Override
	public void updateOrderMethod(OrderMethod ob) {
		ht.update(ob);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getOrderMethodOrderTypeCount() {
        String hql="select orderType ,count(orderType) "
        		+ " from in.nit.model.OrderMethod group by orderType";
		return (List<Object[]>) ht.find(hql);
	}

	@Override
	public List<Object[]> getOrderIdAndOrderCode(String orderMode) {
		String hql=" select orderId,orderCode from in.nit.model.OrderMethod where orderMode=?0 ";
		List<Object[]> list=(List<Object[]>) ht.find(hql,orderMode);
		return list;
	}
}
