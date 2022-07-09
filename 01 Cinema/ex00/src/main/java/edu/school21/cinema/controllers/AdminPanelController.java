package edu.school21.cinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/panel")
public class AdminPanelController {

    @RequestMapping(value = "/halls", method = RequestMethod.GET)
    public String getHalls() {
            return "halls";
    }
}
