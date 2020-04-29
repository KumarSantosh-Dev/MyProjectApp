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

import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/whUserType")
public class WhUserTypeRestController {

	@Autowired
	private IWhUserTypeService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> savewhUserType(
			      @RequestBody WhUserType whUserType
			     ){
		Integer id=service.saveWhUserType(whUserType);
		ResponseEntity<String> resp=new ResponseEntity<String>("One WhUserType Saved with id:"+id,HttpStatus.OK);
		return resp;
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> removeWhUserType(
			       @RequestParam("id")Integer id
			      ) {
		service.removeWhUserType(id);
		ResponseEntity<String> resp=new ResponseEntity<String>("WhUserType id:"+id+"Deleted",HttpStatus.OK);
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateWhUserType(
			     @RequestBody WhUserType whUserType
			    ){
		Integer id=service.saveWhUserType(whUserType);
		ResponseEntity<String> resp=new ResponseEntity<String>("One WhUserType Updateded with id:"+whUserType.getUserId(),HttpStatus.OK);
		return resp;
	}
	@GetMapping("/all")
	public ResponseEntity<List<WhUserType>> fetchAllWhUserType(){
		List<WhUserType> whUserType=service.getAllWhUserTypes();
		ResponseEntity<List<WhUserType>> resp=new ResponseEntity<List<WhUserType>>(whUserType,HttpStatus.OK);
		return resp;
	}
	@GetMapping("/one")
	public ResponseEntity<WhUserType> getOneWhUserType(
			      @RequestParam("id") Integer id
			      ){
		WhUserType whUserType=service.getOneWhUserType(id);
		ResponseEntity<WhUserType> resp=new ResponseEntity<WhUserType>(whUserType,HttpStatus.OK);
		return resp;
	}
	
	
}
