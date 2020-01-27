package stanislaw.appdemo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import stanislaw.appdemo.user.User;

import javax.ws.rs.GET;
import java.util.List;

@Controller
public class AdminPageController {

    final static int NUMBER_OF_ROWS_PER_PAGE = 3;

    @Autowired
    private AdminService adminService;

    @GET
    @RequestMapping(value = "/admin")
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminMainPage(Model model){
        return "admin/admin";
    }

    @GET
    @RequestMapping(value="/admin/users/{page}")
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminAllUsersPage(@PathVariable("page") int page, Model model){
        // URL page will start with 1 which is more convenient for humans,
        // so 1 needs to be subtracted
        Page<User> usersPage = getAllUsersPageable(page-1);
        final int totalPagesNumber = usersPage.getTotalPages();
        int currentPageNumber = usersPage.getNumber();
        List<User> usersList = usersPage.getContent();
        model.addAttribute("totalPagesNumber", totalPagesNumber);
        model.addAttribute("currentPageNumber", currentPageNumber+1);   // Adding 1 because indexing differences
        model.addAttribute("usersList", usersList);
        model.addAttribute("recordCounterStart", currentPageNumber * NUMBER_OF_ROWS_PER_PAGE);
        return "admin/users";
    }


    private Page<User> getAllUsersPageable(int pageNumber){
        Page<User> usersPage = adminService.findAll(PageRequest.of(pageNumber, NUMBER_OF_ROWS_PER_PAGE));
        for(User user: usersPage){
            int nrRole = user.getRoles().iterator().next().getId();
            user.setNrRole(nrRole);
        }

        return usersPage;
    }

}
