/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbd.frontend.controller;

import dbd.model.Student;
import dbd.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dear
 */
@Controller
public class RegistrationController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("registerForm", new StudentViewModel());

        return "register/registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute StudentViewModel registerForm) {

        String name = registerForm.getName();
        String nrMatricol = registerForm.getMatriculationNumber();
        String username = registerForm.getUsername();
        String password = registerForm.getPassword();

        Student student = registerService.registerAsStudent(username, password, name, nrMatricol);

        return "redirect:../frontend";

    }
}
