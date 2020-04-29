package in.nit.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Uom;
import in.nit.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {

	@Autowired
	private IUomService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUom(
			      @RequestBody Uom uom
			     ){
		Integer id=service.saveUom(uom);
		ResponseEntity<String> resp=new ResponseEntity<String>("One Uom Saved with id:"+id,HttpStatus.OK);
		return resp;
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> removeUom(
			       @RequestParam("id")Integer id
			      ) {
		service.removeUomById(id);
		ResponseEntity<String> resp=new ResponseEntity<String>("Uom id:"+id+"Deleted",HttpStatus.OK);
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUom(
			     @RequestBody Uom uom
			    ){
		Integer id=service.saveUom(uom);
		ResponseEntity<String> resp=new ResponseEntity<String>("One Uom Updateded with id:"+uom.getUomId(),HttpStatus.OK);
		return resp;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Uom>> fetchAllUom(){
		List<Uom> uoms=service.getAllUoms();
		ResponseEntity<List<Uom>> resp=new ResponseEntity<List<Uom>>(uoms,HttpStatus.OK);
		return resp;
	}
	@GetMapping("/one")
	public ResponseEntity<Uom> getOneUom(
			      @RequestParam("id") Integer id
			      ){
		Uom uom=service.getOneUom(id);
		ResponseEntity<Uom> resp=new ResponseEntity<Uom>(uom,HttpStatus.OK);
		return resp;
	}
	
	
}
