package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IWhUserTypeDao;
import in.nit.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao{

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhUserType(WhUserType ob) {
		return (Integer)ht.save(ob);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

	@Override
	public void removeWhUserType(Integer id) {
		ht.delete(new WhUserType(id));
	}

	@Override
	public WhUserType getOneWhUserType(Integer id) {
		return ht.get(WhUserType.class, id);
	}

	@Override
	public void updateWhUserType(WhUserType ob) {
		ht.update(ob);
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getWhUserType_TypeCount() {
		String hql="select userType ,count(userType) "
				+ " from in.nit.model.WhUserType group by userType";
		return (List<Object[]>) ht.find(hql);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getWhUserIdAndCode(String userType) {
		String hql=" select userId,userCode from "+WhUserType.class.getName() +" where userType=?0 ";
		return (List<Object[]>) ht.find(hql, userType);
	}
	
	@Override
	public boolean isUserCodeExist(String userCode) {
		boolean flag=false;
		String hql=" SELECT COUNT(userCode) FROM in.nit.model.WhUserType WHERE userCode=?0 ";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql, userCode);
		
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0)
				flag=false;
			else
				flag=true;
		}
		return flag;
	}
	@Override
	public boolean isUserEmailExist(String userEmail) {
		boolean flag=false;
		String hql=" SELECT COUNT(userEmail) FROM in.nit.model.WhUserType WHERE userEmail=?0 ";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql, userEmail);
		
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0)
				flag=false;
			else
				flag=true;
		}
		return flag;
	}
	
	@Override
	public boolean isUserContactExist(String userContact) {
		boolean flag=false;
		String hql=" SELECT COUNT(userContact) FROM in.nit.model.WhUserType WHERE userContact=?0 ";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql, userContact);
		
		if(list!=null && !list.isEmpty()) {
			long count=list.get(0);
			if(count==0)
				flag=false;
			else
				flag=true;
		}
		return flag;
	}
	@Override
	public boolean isidNumExist(String idNum) {
		boolean flag=false;
		String hql=" SELECT COUNT(idNum) FROM in.nit.model.WhUserType WHERE idNum=?0 ";
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Long> list=(List<Long>) ht.find(hql, idNum);
		
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
