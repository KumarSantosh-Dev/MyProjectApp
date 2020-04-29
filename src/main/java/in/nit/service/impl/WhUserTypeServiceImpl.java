package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhUserTypeDao;
import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService{
	
	@Autowired
	private IWhUserTypeDao dao;

	@Transactional
	public Integer saveWhUserType(WhUserType ob) {
		return dao.saveWhUserType(ob);
	}
	
    @Transactional(readOnly = true)
	public List<WhUserType> getAllWhUserTypes() {
    	List<WhUserType> list=dao.getAllWhUserTypes();
        list.stream().sorted((w1,w2)->w2.getUserId()-w1.getUserId());
        return list;
	}
	
    @Transactional
    public void removeWhUserType(Integer id) {
    	dao.removeWhUserType(id);
	}

	@Transactional(readOnly = true)
	public WhUserType getOneWhUserType(Integer id) {
		return dao.getOneWhUserType(id);
	}

	@Transactional
	public void updateWhUserType(WhUserType ob) {
		dao.updateWhUserType(ob);
	}
	
    @Transactional
	public List<Object[]> getWhUserType_TypeCount() {
		return dao.getWhUserType_TypeCount();
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getWhUserIdAndCode(String userType) {
		return dao.getWhUserIdAndCode(userType);
	}
	
	@Transactional(readOnly = true)
	public boolean isUserCodeExist(String userCode) {
		return dao.isUserCodeExist(userCode);
	}
	@Transactional(readOnly = true)
	public boolean isUserEmailExist(String userEmail) {
		return dao.isUserEmailExist(userEmail);
	}
	@Transactional(readOnly = true)
	public boolean isUserContactExist(String userContact) {
		return dao.isUserContactExist(userContact);
	}
	@Transactional(readOnly = true)
	public boolean isidNumExist(String idNum) {
		return dao.isidNumExist(idNum);
	}
}
