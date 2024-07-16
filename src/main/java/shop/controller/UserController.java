package shop.controller;



import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shop.dto.GoodDto;
import shop.dto.UserDto;
import shop.model.entity.Good;
import shop.model.entity.User;
import shop.service.impl.GoodServiceImpl;
import shop.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/user")
@EnableWebMvc
public class UserController {

    Logger logger = Logger.getLogger(UserController.class.getName());

    GoodServiceImpl goodService;
    UserServiceImpl userService;

    @Autowired
    public UserController(GoodServiceImpl goodService, UserServiceImpl userService) {
        this.goodService = goodService;
        this.userService = userService;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        logger.log(Level.INFO, "UserController @GetMapping getLoginPage");
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "page1";
    }

    @PostMapping
    public String createNew(HttpSession session,
                            Model model,
                            @RequestParam(value = "username", required = false) String name,
                            @RequestParam(value = "password", required = false) String password) {

        Map<Long, GoodDto> goods = goodService.findAllGoods();
        logger.log(Level.INFO, "From goodService.findAllGoods(): " + goods);
        logger.log(Level.INFO, "UserController @PostMapping:  " + name+ "   "+password);
        userService.registration(name, password);
        UserDto user = userService.findByLogin(name);
        logger.log(Level.INFO, "From UserController to view :   " + user);
        model.addAttribute("user", user);
        model.addAttribute("list", goods);
        model.addAttribute("username", name);
        session.setAttribute("user", user);
        return "page2";
    }
}
