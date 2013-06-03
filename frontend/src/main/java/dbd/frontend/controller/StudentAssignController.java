/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbd.frontend.controller;

import dbd.model.Assignment;
import dbd.service.AssignmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author madalina
 */
@Controller
public class StudentAssignController {
    
     @Autowired
    private AssignmentService assignService;

    @RequestMapping(value = "/chooseAssignment", method = RequestMethod.GET)
    public String viewAssignments(Model model) {

        //TODO
        //get assign dupa student,year,semester,course
        List<Assignment> assignments = assignService.getAllAssignments();
        assignments.add(new Assignment());
        model.addAttribute("assignments", assignments);
            return "assignments/chooseAssignment";

    }
}
