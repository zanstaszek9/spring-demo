package stanislaw.appdemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import stanislaw.appdemo.emailSender.EmailSender;
import stanislaw.appdemo.utilities.AppdemoUtils;
import stanislaw.appdemo.validators.UserRegisterValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Locale;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    MessageSource messageSource;    // Allows to obtain messages from message.properties to Java code

    @GET
    @RequestMapping(value = "/register")
    public String registerForm(Model model){
        User u = new User();
        String title = "<s:message code=\"menu.register\"/>";
        model.addAttribute("user", u);  // Takes modelAttribute from jsp page
        model.addAttribute("title", title);
        return "register";
    }

    @POST
    @RequestMapping(value = "/adduser")
    public String registerAction(User user, BindingResult result, Model model, Locale locale){  // BindingResult for validation, Locale for messageSource

        String returnPage = "register";

        User userExist = userService.findUserByEmail(user.getEmail());

        new UserRegisterValidator().validate(user, result);
        new UserRegisterValidator().validateEmailExist(userExist, result);

        if (!(result.hasErrors())){
            /*
            user.setActivationCode(AppdemoUtils.authorizationStringGenerator());
            String emailContent = (messageSource.getMessage("register.clickConfirmation", null, locale))+"\n" +
                    "http://localhost:8080/activatelink/"+user.getActivationCode();
             */
            userService.saveUser(user);
            //emailSender.sendEmail(user.getEmail(), messageSource.getMessage("email.subject.registerConfirmation",null, locale), emailContent);
            model.addAttribute("message", messageSource.getMessage("user.register.success.email", null, locale));

            //model.addAttribute("user", new User());
            returnPage = "index";
        }

        return returnPage;
    }


    /*
    @POST
    @RequestMapping(value = "/activatelink/{activationCode}")
    public String activationAccount(@PathVariable("activationCode") String activationCode, Model model, Locale locale) {
        userService.updateUserActivation(1, activationCode);
        model.addAttribute("message", messageSource.getMessage("user.register.success",null, locale));
        return "index";
    }
*/
}
