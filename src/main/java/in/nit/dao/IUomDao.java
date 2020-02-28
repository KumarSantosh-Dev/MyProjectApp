package in.nit.dao;

import java.util.List;

import in.nit.model.Uom;

public interface IUomDao {
   
	Integer saveUom(Uom u);
	List<Uom> getAllUoms();
	void removeUomById(Integer id);
	Uom getOneUom(Integer id);
	void updateUom(Uom ob);
}