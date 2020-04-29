package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;

@Component
public class WhUserTypeValidaor implements Validator{
	@Autowired
	private IWhUserTypeService service;

	@Override
	public boolean supports(Class<?> cls) {
		return WhUserType.class.equals(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WhUserType whUserType=(WhUserType) target;
		if(service.isUserCodeExist(whUserType.getUserCode())){
			errors.rejectValue("userCode", null , "UserCode '"+whUserType.getUserCode()+" 'Already Exist");
		}
		if(service.isUserEmailExist(whUserType.getUserEmail())){
			errors.rejectValue("userEmail", null , "UserEmail '"+whUserType.getUserEmail()+" 'Already Exist");
		}
		if(service.isUserContactExist(whUserType.getUserContact())){
			errors.rejectValue("userContact", null , "UserContact '"+whUserType.getUserContact()+" 'Already Exist");
		}
		if(service.isidNumExist(whUserType.getIdNum())){
			errors.rejectValue("idNum", null , "IdNum '"+whUserType.getIdNum()+" 'Already Exist");
		}
	}

}
