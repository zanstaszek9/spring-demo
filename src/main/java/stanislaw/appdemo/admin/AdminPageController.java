package stanislaw.appdemo.admin;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.ws.rs.GET;

@Controller
public class AdminPageController {

    @GET
    @RequestMapping(value = "/admin")
    @Secured(value = {"ROLE_ADMIN"})    // TODO: Check if user can after adding ROLE_USER
    public String showUAdminMainPage(Model model){
        return "admin/admin";
    }
}
