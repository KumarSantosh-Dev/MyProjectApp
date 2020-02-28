package in.nit.service;

import java.util.List;

import in.nit.model.WhUserType;

public interface IWhUserTypeService {
 
	Integer saveWhUserType(WhUserType ob);
	List<WhUserType> getAllWhUserTypes();
	void removeWhUserType(Integer id);

	WhUserType getOneWhUserType(Integer id);
	void updateWhUserType(WhUserType ob);

}
