package com.nagarro.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.model.User;
 
@Controller
public class HomeController {
 
    @RequestMapping(value = "/")
    public String home(ModelMap modelMap) {
    	modelMap.addAttribute("user", new User());
    	modelMap.addAttribute("message", "");
        return "index";
    }
 
}