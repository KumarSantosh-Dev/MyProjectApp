package in.nit.service;

import java.util.List;

import in.nit.model.SaleOrder;

public interface ISaleOrderService {
 
	Integer saveSaleOrder(SaleOrder ob);
	List<SaleOrder> getAllSaleOrders();
	void deleteSaleOrder(Integer id);
	
	SaleOrder getOneSaleOrder(Integer id);
	void updateSaleOrder(SaleOrder ob);
	
}
