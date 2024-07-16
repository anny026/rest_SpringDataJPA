package shop.controller;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import shop.dto.GoodDto;
import shop.dto.OrderDto;
import shop.dto.OrderGoodDto;
import shop.dto.UserDto;
import shop.model.entity.Good;
import shop.model.entity.Order;
import shop.model.entity.OrderGood;
import shop.model.entity.User;
import shop.service.OrderService;
import shop.service.impl.GoodServiceImpl;
import shop.service.impl.OrderGoodServiceImpl;
import shop.service.impl.OrderServiceImpl;
import shop.service.impl.UserServiceImpl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@EnableWebMvc
@RequestMapping("/hello")
public class ShopController {

    Logger logger = Logger.getLogger(ShopController.class.getName());
    UserServiceImpl userService;
    OrderServiceImpl orderService;
    GoodServiceImpl goodService;
    OrderGoodServiceImpl orderGoodService;

    @Autowired
    public ShopController(UserServiceImpl userService,
                          OrderServiceImpl orderService,
                          GoodServiceImpl goodService,
                          OrderGoodServiceImpl orderGoodService) {
        this.userService = userService;
        this.orderService = orderService;
        this.goodService = goodService;
        this.orderGoodService = orderGoodService;
    }

    @PostMapping
    public String handleGetSubmit(HttpServletRequest request,
                                  HttpSession session,
                                  Model model,
                                  @ModelAttribute("user") UserDto user,
                                  @ModelAttribute("item") Integer key,
                                  @RequestParam("submitForm") String action) {
        String submit = request.getParameter("submitForm");
        UserDto userDto = (UserDto) session.getAttribute("user");
        logger.log(Level.INFO, "ShopController submitForm: " + action);
        logger.log(Level.INFO, "ShopController userDto: " + userDto);
        if (submit == null) {
            submit = "browse";
        }
        if (submit.equalsIgnoreCase("addToCart")) {
            addItem(request, model, userDto);
            session.setAttribute("user", userDto);
            model.addAttribute("user", userDto);
            Map<Long, GoodDto> goods = goodService.findAllGoods();
            model.addAttribute("list", goods);
            return "page3";
        }
        if (submit.equalsIgnoreCase("Submit")) {
            model.addAttribute("user", userDto);
            return "page4";
        } else return "pageOops";
    }


    private void addItem(HttpServletRequest request, Model model, UserDto user) {
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ArrayList<String>());
        }
        Integer shopCart = (Integer) session.getAttribute("shopCart");
        if (shopCart == null) {
            shopCart = 0;
        }
        Integer key = Integer.parseInt(request.getParameter("item"));
        Integer priceItem = goodService.findPriceByKey(key);
        Long idItem = goodService.findIdByKey(key);
        GoodDto goodToOrder = goodService.findIdBy(idItem);
        orderService.addOrder(user, priceItem);
        OrderDto order_new = orderService.findOrderByIdUser(user.getId());
        orderGoodService.addOrderGood(goodToOrder, order_new);
        Map<Long, OrderGoodDto> goodDaoMap = orderGoodService.findOrderedGoods(order_new);
        session.setAttribute("list2", goodDaoMap);
        session.setAttribute("list4", order_new);
        model.addAttribute("list2", goodDaoMap);
        model.addAttribute("list4", order_new);
    }

}
