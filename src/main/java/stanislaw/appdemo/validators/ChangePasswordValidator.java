package stanislaw.appdemo.validators;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import stanislaw.appdemo.constants.AppdemoConstants;
import stanislaw.appdemo.user.User;
import stanislaw.appdemo.utilities.AppdemoUtils;

public class ChangePasswordValidator implements Validator {

    @Override
    public boolean supports(Class <?> cls){
        return User.class.equals(cls);
    }


    @Override
    public void validate(Object obj, Errors errors) {
        @SuppressWarnings("unused") //Unused for now, leaving for potential later usage
        User u = (User) obj;

        ValidationUtils.rejectIfEmpty(errors, "newPassword", "error.userPassword.empty");

    }

    public void checkPasswords(String newPass, Errors errors){
        if (!newPass.equals(null)){
            boolean isMatch = AppdemoUtils.checkEmailOrPassword(AppdemoConstants.PASSWORD_PATTERN, newPass);
            if (!isMatch)
                errors.rejectValue("newPassword", "error.userPasswordIsNotMatch");
        }
    }
    // Needed for confirming the typed password matches one in the database
    public void confirmOldPassword(String oldPassword, String encodedPassword, Errors errors){
        if(!(new BCryptPasswordEncoder().matches(oldPassword, encodedPassword)))
            errors.rejectValue("oldPassword", "error.oldPasswordNotMatch");
    }
}
