package stanislaw.appdemo.validators;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import stanislaw.appdemo.constants.AppdemoConstants;
import stanislaw.appdemo.user.User;
import stanislaw.appdemo.utilities.AppdemoUtils;

public class EditUserProfileValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User u = (User) obj;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");

        if(!(u.getEmail().equals(null))){
            boolean isMatch = AppdemoUtils.checkEmailOrPassword(AppdemoConstants.EMAIL_PATTERN, u.getEmail());
            if(!isMatch)
                errors.rejectValue("email", "error.userEmailIsNotMatch");
        }
    }
}
