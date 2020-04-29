package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveShipmentType(ShipmentType ob) {
		return (Integer)ht.save(ob);
	}


	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public void deleteShipmentType(Integer id) {
		ht.delete(new ShipmentType(id));
	}

	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		return ht.get(ShipmentType.class, id);
	}

	@Override
	public void updateShipmentType(ShipmentType ob) {
		ht.update(ob);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getShipmentModeCount() {
		String hql="select shipMode,count(shipMode) from in.nit.model.ShipmentType group by shipMode";
		return (List<Object[]>) ht.find(hql);
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getShipmentIdAndCode() {
		String hql=" select shipId,shipCode from "+ ShipmentType.class.getName()+" where enbShip='YES' ";
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}	
	
	@Override
	public boolean isShipCodeExist(String shipCode) {
		boolean flag=false;
		String hql=" SELECT COUNT(shipCode) FROM in.nit.model.ShipmentType WHERE shipCode=?0 ";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql, shipCode);
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0) 
				flag=false;
			else
				flag=true;
		}
		return flag;
	}

}
