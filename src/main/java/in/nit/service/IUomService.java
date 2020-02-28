package in.nit.service;

import java.util.List;

import in.nit.model.Uom;

public interface IUomService {

	Integer saveUom(Uom u);
	List<Uom> getAllUoms();
	void removeUomById(Integer id);
	Uom getOneUom(Integer id);
	void updateUom(Uom ob);
	
	List<Object[]> getUomTypeCount();

}
