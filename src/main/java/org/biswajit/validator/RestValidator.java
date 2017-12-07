package org.biswajit.validator;

import org.biswajit.data.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateUser")
public class RestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user=(User)target;
		if(checkInputString(user.getFirstName())){
			errors.rejectValue("firstName", "firstName.empty");
		}
	}
	
	private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
