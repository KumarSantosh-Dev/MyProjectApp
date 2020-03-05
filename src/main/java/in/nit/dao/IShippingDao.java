package in.nit.dao;

import java.util.List;

import in.nit.model.Shipping;

public interface IShippingDao {
 
	Integer saveShipping(Shipping ob);
	List<Shipping> getAllShippings();
	void deleteShipping(Integer id);
	
	Shipping getOneShipping(Integer id);
	void updateShipping(Shipping ob);
	
}
