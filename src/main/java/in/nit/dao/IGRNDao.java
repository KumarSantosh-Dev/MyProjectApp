package in.nit.dao;

import java.util.List;
import in.nit.model.GRN;

public interface IGRNDao {
 
	Integer saveGRN(GRN ob);
	List<GRN> getAllGRNs();
	void deleteGRN(Integer id);
	
	GRN getOneGRN(Integer id);
	void updateGRN(GRN ob);
	
}
