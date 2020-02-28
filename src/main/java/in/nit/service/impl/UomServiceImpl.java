package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;

@Service
public class UomServiceImpl implements IUomService{

	@Autowired
	private IUomDao dao;
    
	@Transactional
	public Integer saveUom(Uom u) {
		return dao.saveUom(u);
	}

	
	@Transactional(readOnly = true)
	public List<Uom> getAllUoms() {
		List<Uom> list=dao.getAllUoms();
		list.stream()
		.sorted( (o1,o2)->o1.getUomId()-o1.getUomId() );
		
		return list;
	}
	
    @Transactional
	public void removeUomById(Integer id) {
    	dao.removeUomById(id);
	}
    
    @Transactional
    public Uom getOneUom(Integer id) {
    	return dao.getOneUom(id);
    }
    
    @Transactional
    public void updateUom(Uom ob) {
    	dao.updateUom(ob);
    }
    

    public List<Object[]> getUomTypeCount() {
    	return dao.getUomTypeCount();
    }
}
