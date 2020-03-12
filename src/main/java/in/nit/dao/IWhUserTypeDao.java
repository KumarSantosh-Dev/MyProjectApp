package in.nit.dao;

import java.util.List;

import in.nit.model.WhUserType;

public interface IWhUserTypeDao {

	Integer saveWhUserType(WhUserType ob);
	List<WhUserType> getAllWhUserTypes();
	void removeWhUserType(Integer id);
	
	WhUserType getOneWhUserType(Integer id);
	void updateWhUserType(WhUserType ob);
	
	List<Object[]> getWhUserType_TypeCount();
	
	List<Object[]> getWhUserIdAndCode(String userType);
}
