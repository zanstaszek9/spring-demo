package stanislaw.appdemo.mainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class MainPageController {

    @GET
    @RequestMapping(value = {"/", "/index"})
    public String showMainPage(){
        return "index";
    }

}
