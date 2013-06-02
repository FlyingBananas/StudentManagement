package dbd.frontend.controller;

import dbd.model.Assignment;
import dbd.service.AssignmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madalina
 */
@Controller
public class AssignmentsController {

    @Autowired
    private AssignmentService assignService;

    @RequestMapping(value = "/assignments", method = RequestMethod.GET)
    public String viewAssignments(Model model) {

        List<Assignment> assignments = assignService.getAllAssignments();
        assignments.add(new Assignment());
        model.addAttribute("assignments", assignments);
            return "assignments/viewAssignments";

    }
    
    @RequestMapping(value = "/assignments/{name}", method = RequestMethod.GET)
    public String editAssignment(Model model, @PathVariable String name) {

        Assignment assignment=null;
        try{
            assignment = (Assignment) assignService.getAssignmentByName(name).get(0);
        }catch(Exception e){
            
        }
        model.addAttribute("assignment", assignment);
            return "assignments/editAssignment";

    }
    
    @RequestMapping(value = "/assignments/{name}", method = RequestMethod.POST)
    public String editAssignment(@ModelAttribute("assignment") Assignment assignment, BindingResult result,Model model,@PathVariable String name) {   
            //update Assignment
            return "redirect:/assignments";

    }
    
        @RequestMapping(value = "/assignments/add", method = RequestMethod.GET)
    public String addAssignment( Model model) {
        
        //insert Assignment
         return "assignments/addAssignment";
	}
    
    @RequestMapping(value = "/assignments/add", method = RequestMethod.POST)
    public String addAssignment(@ModelAttribute("assignment")  Assignment assignment,
			BindingResult result, Model model) {
        
        //insert Assignment
         return "redirect:/assignments";
	}
}
