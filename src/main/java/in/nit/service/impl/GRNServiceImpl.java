package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IGRNDao;
import in.nit.model.GRN;
import in.nit.service.IGRNService;

@Service
public class GRNServiceImpl implements IGRNService {

	@Autowired
	private IGRNDao dao;
	
	@Transactional
	public Integer saveGRN(GRN ob) {
		return dao.saveGRN(ob);
	}

	@Transactional(readOnly = true)
	public List<GRN> getAllGRNs() {
		return dao.getAllGRNs();
	}

	@Transactional
	public void deleteGRN(Integer id) {
		dao.deleteGRN(id);
	}

	@Transactional(readOnly = true)
	public GRN getOneGRN(Integer id) {
		return dao.getOneGRN(id);
	}

	@Transactional
	public void updateGRN(GRN ob) {
		dao.updateGRN(ob);
	}

}
