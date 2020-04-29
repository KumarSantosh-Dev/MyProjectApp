package in.nit.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Component
public class OrderMethodValidator implements Validator{
	@Autowired
	private IOrderMethodService service;

	@Override
	public boolean supports(Class<?> cls) {
		return OrderMethod.class.equals(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod orderMethod=(OrderMethod) target;
		if(service.isOrderCodeExist(orderMethod.getOrderCode())) {
			errors.rejectValue("orderCode", null, "OrderCode '"+orderMethod.getOrderCode()+" 'Already Exist!!!");
		}
	}

}
