package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;

	@Transactional
	public Integer saveOrderMethod(OrderMethod ob) {
		return dao.saveOrderMethod(ob);
	}

	@Transactional(readOnly = true)
	public List<OrderMethod> getAllOrderMethods() {
		return dao.getAllOrderMethods();
	}

	@Transactional
	public void removeOrderMethod(Integer id) {
		dao.removeOrderMethod(id);
	}

	@Transactional(readOnly = true)
	public OrderMethod getOneOrderMethod(Integer id) {
		return dao.getOneOrderMethod(id);
	}
	
	@Transactional
	public void updateOrderMethod(OrderMethod ob) {
		dao.updateOrderMethod(ob);
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getOrderMethodOrderTypeCount() {
		return dao.getOrderMethodOrderTypeCount();
	}
	
    @Transactional(readOnly = true)
	public List<Object[]> getOrderIdAndOrderCode(String orderMode) {
		return dao.getOrderIdAndOrderCode(orderMode);
	}
	
	@Transactional(readOnly = true)
	public boolean isOrderCodeExist(String orderCode) {
		return dao.isOrderCodeExist(orderCode);
	}
}
