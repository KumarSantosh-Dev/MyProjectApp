package in.nit.dao;

import java.util.List;

import in.nit.model.Part;

public interface IPartDao {
 
	Integer savePart(Part ob);
	List<Part> getAllParts();
	void deletePart(Integer id);
	
	Part getOnePart(Integer id);
	void updatePart(Part ob);
	
}
