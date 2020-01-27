package stanislaw.appdemo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stanislaw.appdemo.user.User;
import stanislaw.appdemo.user.UserService;

import javax.ws.rs.GET;
import java.util.List;

@Controller
public class AdminPageController {

    @Autowired
    private AdminService adminService;

    @GET
    @RequestMapping(value = "/admin")
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminMainPage(Model model){
        return "admin/admin";
    }

    @GET
    @RequestMapping(value="/admin/users")
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminAllUsersPage(Model model){
        List <User> userList = getAllUsers();
        model.addAttribute("userList", userList);
        return "admin/users";
    }

    private List<User> getAllUsers(){
        List<User> usersList = adminService.findAll();
        for(User user:usersList){
            int nrRole = user.getRoles().iterator().next().getId();
            user.setNrRole(nrRole);
        }
        return usersList;
    }

}
