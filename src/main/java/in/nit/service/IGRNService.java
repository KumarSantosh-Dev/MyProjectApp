package in.nit.service;

import java.util.List;
import in.nit.model.GRN;

public interface IGRNService {
 
	Integer saveGRN(GRN ob);
	List<GRN> getAllGRNs();
	void deleteGRN(Integer id);
	
	GRN getOneGRN(Integer id);
	void updateGRN(GRN ob);
	
}
