package stanislaw.appdemo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import stanislaw.appdemo.user.User;
import stanislaw.appdemo.utilities.UserUtilities;
import stanislaw.appdemo.validators.EditUserProfileValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class AdminPageController {

    final static int NUMBER_OF_ROWS_PER_PAGE = 3;
    final static int MIN_SEARCH_LENGTH = 3;

    @Autowired
    private AdminService adminService;

    @Autowired
    private MessageSource messageSource;

    @GET
    @RequestMapping(value = "/admin")
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminMainPage(Model model){
        return "admin/admin";
    }

    @GET
    @RequestMapping(value={"/admin/users/","/admin/users"})
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminAllUsersPage(Model model){
        return "redirect:/admin/users/1";
    }

    @GET
    @RequestMapping(value="/admin/users/{page}")
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminAllUsersPage(@PathVariable("page") int page, @RequestParam(required = false, defaultValue = "") String search, Model model){
        Page<User> usersPage = getUsersPageable(page, search);
        List<User> usersList = usersPage.getContent();

        final int totalPagesNumber = usersPage.getTotalPages();
        int currentPageNumber = usersPage.getNumber();

        model.addAttribute("totalPagesNumber", totalPagesNumber);
        model.addAttribute("currentPageNumber", currentPageNumber+1);   // Adding 1 because indexing differences
        model.addAttribute("usersList", usersList);
        model.addAttribute("recordCounterStart", currentPageNumber * NUMBER_OF_ROWS_PER_PAGE);
        model.addAttribute("searchParam", search.isEmpty()? search : "?search="+search);

        return "admin/users";
    }

    private Page<User> getUsersPageable(int pageNumber, String search){
        // URL page will start with 1 which is more convenient for humans,
        // so 1 needs to be subtracted
        --pageNumber;
        Page<User> usersPage;

        if(!search.isEmpty() && search.length() >= MIN_SEARCH_LENGTH)
            usersPage = adminService.findAllSearch(search, PageRequest.of(pageNumber, NUMBER_OF_ROWS_PER_PAGE));
        else
            usersPage = adminService.findAll(PageRequest.of(pageNumber, NUMBER_OF_ROWS_PER_PAGE));

        setUsersRole(usersPage);
        return usersPage;
    }


    @GET
    @RequestMapping(value="/admin/users/edit/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminUserToEdit(@PathVariable("id") int id, Model model){
        User user = adminService.findUserById(id);
        int role = user.getRoles().iterator().next().getId();
        user.setNrRole(role);

        Map<Integer, String> roleMap = prepareRoleMap();
        Map<Integer, String> activityMap = prepareActivityMap();

        model.addAttribute("roleMap", roleMap);
        model.addAttribute("activityMap", activityMap);
        model.addAttribute("user", user);
        return "admin/useredit";
    }

    @POST
    @RequestMapping(value = "/admin/users/update/{id}")
    @Secured(value = {"ROLE_ADMIN"})
    public String updateUser(@PathVariable("id") int id, User user){
        adminService.updateUser(user);
        return "redirect:/admin/users/1";    // Redirect to land exactly on this URL instead of concating the address
    }




    @GET
    @RequestMapping(value="/admin/users/importusers")
    @Secured(value = {"ROLE_ADMIN"})
    public String showAdminUploadUsersPageFromXML(Model model){
        return "/admin/importusers";
    }

    @POST
    @RequestMapping(value = "/admin/users/upload")
    @Secured(value = "ROLE_ADMIN")
    public String importUsersFromXML(@RequestParam("filename") MultipartFile mFile){
        try {
            uploadFileToServer(mFile);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/users/1";
    }

    private void uploadFileToServer(MultipartFile mFile) throws IOException {
        String uploadDir = System.getProperty("user.dir") + "/uploads";
        createOrFindUploadDirectory(uploadDir);

        Path fileAndPath = Paths.get(uploadDir, mFile.getOriginalFilename());
        Files.write(fileAndPath, mFile.getBytes());
    }

    private void createOrFindUploadDirectory(String uploadDir) {
        File file = new File(uploadDir);
        if(!file.exists())
            file.mkdir();
    }

    public void setUsersRole(Iterable<User> users){
        for(User user : users){
            int nrRole = user.getRoles().iterator().next().getId();
            user.setNrRole(nrRole);
        }
    }

    private Map<Integer, String> prepareRoleMap(){
        Locale locale = Locale.getDefault();
        Map<Integer, String> roleMap = new HashMap<Integer, String>();
        roleMap.put(1, messageSource.getMessage("word.admin", null, locale));
        roleMap.put(2, messageSource.getMessage("word.user", null, locale));
        return roleMap;
    }

    private Map<Integer, String> prepareActivityMap(){
        Locale locale = Locale.getDefault();
        Map<Integer, String> activityMap = new HashMap<Integer, String>();
        activityMap.put(0, messageSource.getMessage("word.no", null, locale));
        activityMap.put(1, messageSource.getMessage("word.yes", null, locale));
        return activityMap;
    }
}
