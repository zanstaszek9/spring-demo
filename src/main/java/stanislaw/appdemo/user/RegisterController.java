package stanislaw.appdemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import stanislaw.appdemo.validators.UserRegisterValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.Locale;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    MessageSource messageSource;    // Allows to obtain messages from message.properties to Java code

    @GET
    @RequestMapping(value = "/register")
    public String registerForm(Model model){
        User u = new User();
        model.addAttribute("user", u);  // Takes modelAttribute from jsp page
        return "register";
    }

    @POST
    @RequestMapping(value = "/adduser")
    public String registerAction(User user, BindingResult result, Model model, Locale locale){  // BindingResult for validation, Locale for messageSource

        String returnPage = null;   // To return page

        User userExist = userService.findUserByEmail(user.getEmail());

        new UserRegisterValidator().validate(user, result);

        if (userExist != null)  // If email exists
            result.rejectValue("email", messageSource.getMessage("error.userEmailExist", null, locale));    // If user exists, 'result' will contain error

        if (result.hasErrors())
            returnPage = "register";
        else {
            userService.saveUser(user);
            model.addAttribute("message", messageSource.getMessage("user.register.success",null, locale));  // Attribute message from /WEB-INF/jsp/register.jsp:23
            model.addAttribute("user", new User());
            returnPage = "register";

        }

        return returnPage;  // TODO: Change redirect page in future
    }

}
