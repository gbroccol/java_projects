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

    @RequestMapping(value = "/halls", method = RequestMethod.POST)
    public String updateHalls() {
        return "halls";
    }

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public String getFilms() {
        return "films";
    }

    @RequestMapping(value = "/films", method = RequestMethod.POST)
    public String updateFilms() {
        return "films";
    }

    @RequestMapping(value = "/sessins", method = RequestMethod.GET)
    public String getSessions() {
        return "sessions";
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    public String updateSessions() {
        return "sessions";
    }
}
