package ltd.newbee.mall.controller.mall;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PalworldServerController {

    @GetMapping("/palworld_server_console")
    public String personalPage(HttpServletRequest request,
                               HttpSession httpSession) {
        request.setAttribute("path", "palworld_server_console");
        return "mall/palworld_server_console";
    }
}
