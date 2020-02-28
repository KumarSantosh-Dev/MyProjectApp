package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
    
	@Autowired
	private IShipmentTypeDao dao;
	
    @Transactional
	public Integer saveShipmentType(ShipmentType ob) {
		return dao.saveShipmentType(ob);
	}
    
    @Transactional(readOnly = true)
    public List<ShipmentType> getAllShipmentTypes() {
    	List<ShipmentType> list=dao.getAllShipmentTypes();
    	Collections.sort(list,(ob1,ob2)->{return ob1.getShipId()-ob2.getShipId();});
    	return list;
    }
    
    @Transactional
    public void deleteShipmentType(Integer id) {
    	dao.deleteShipmentType(id);
    }

    @Transactional(readOnly = true)
    public ShipmentType getOneShipmentType(Integer id) {
    	return dao.getOneShipmentType(id);
    }
    
    @Transactional
    public void updateShipmentType(ShipmentType ob) {
    	dao.updateShipmentType(ob);
    }
    
    @Override
    public List<Object[]> getShipmentModeCount() {
    	return dao.getShipmentModeCount();
    }
}
