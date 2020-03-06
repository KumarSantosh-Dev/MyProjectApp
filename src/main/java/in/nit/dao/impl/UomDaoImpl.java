package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao{
    
	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveUom(Uom u) {
		return (Integer)ht.save(u);
	}
	
	@Override
	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}
	
	@Override
	public void removeUomById(Integer id) {
        Uom u=new Uom();
        u.setUomId(id);
        ht.delete(u);
	}
	
	@Override
	public Uom getOneUom(Integer id) {
		return ht.get(Uom.class, id);
	}
	
	@Override
	public void updateUom(Uom ob) {
       ht.update(ob);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getUomTypeCount() {
        String hql="select uomType, count(uomType) from in.nit.model.Uom group by uomType";
		return (List<Object[]>) ht.find(hql);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getUomIdAndUomModel() {
        String hql=" select uomId,uomModel from in.nit.model.Uom";
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}
}
