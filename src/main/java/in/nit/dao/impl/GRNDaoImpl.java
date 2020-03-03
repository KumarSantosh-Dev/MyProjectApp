package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IGRNDao;
import in.nit.model.GRN;
@Repository
public class GRNDaoImpl implements IGRNDao {
    @Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveGRN(GRN ob) {
		return (Integer) ht.save(ob);
	}

	@Override
	public List<GRN> getAllGRNs() {
		return ht.loadAll(GRN.class);
	}

	@Override
	public void deleteGRN(Integer id) {
		ht.delete(new GRN(id));
	}

	@Override
	public GRN getOneGRN(Integer id) {
		return ht.get(GRN.class, id);
	}

	@Override
	public void updateGRN(GRN ob) {
		ht.update(ob);
	}

}
