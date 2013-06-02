package dbd.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showTestPage(HttpServletRequest request, HttpServletResponse response,  Model model) {

        String bar = "bar";
        model.addAttribute("foo", bar);
        return "test";
    }

    @RequestMapping(value = "/test/change-bar", method = RequestMethod.POST)
    public String changeBar(HttpServletRequest request, HttpServletResponse response,  Model model) {
        String bar = "banana";
        model.addAttribute("foo", bar);
        return "test";
    }

}
