/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbd.frontend.controller;

import dbd.model.LoginDetails;
import dbd.model.User;
import dbd.service.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author madalina
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {

        LoginDetails loginForm = new LoginDetails();
        model.addAttribute("loginForm", loginForm);

        return "login/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") LoginDetails loginForm,
            BindingResult result, Model model, HttpSession session) {
        
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        User user = loginService.tryLoginAsTeacher(username, password);  
        if (user != null) {     
            session.setAttribute("user", user);
            return "redirect:../frontend/viewAssignments";     
        } 
        
        user = loginService.tryLoginAsStudent(loginForm.getUsername(), loginForm.getPassword());   
        if (user != null) {  
            session.setAttribute("user", user);
            return "redirect:../frontend/chooseAssignment";
        }
          
        model.addAttribute("error", "Incorrect username or password! Please try again!");
        return "login/loginForm";
    }
}
