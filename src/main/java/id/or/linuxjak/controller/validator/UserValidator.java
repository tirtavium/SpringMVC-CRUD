package id.or.linuxjak.controller.validator;

import id.or.linuxjak.controller.domain.UserControllerDomain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("userValidator")
public class UserValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return UserControllerDomain.class.isAssignableFrom(arg0);
	}

	public void validate(Object target, Errors error) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmpty(error, "username","required.ucd.username", "field Username is required");
		ValidationUtils.rejectIfEmpty(error, "password","required.ucd.password", "field password is required");
		ValidationUtils.rejectIfEmpty(error, "passwordConfirm", "required.ucd.passwordConfirm","field password is required");
		ValidationUtils.rejectIfEmpty(error, "name", "required.ucd.name","field name is required");
		ValidationUtils.rejectIfEmpty(error, "lastName","required.ucd.lastName", "field lastName is required");
		ValidationUtils.rejectIfEmpty(error, "address","required.ucd.address", "field address is required");
		ValidationUtils.rejectIfEmpty(error, "job","required.ucd.job", "field job is required");
			
		UserControllerDomain ucd = (UserControllerDomain) target;
			if(!ucd.getPassword().equals(ucd.getPasswordConfirm())){
				error.rejectValue("password", "notmatch.password","field password is not match");
			}
	}

	
	
}
