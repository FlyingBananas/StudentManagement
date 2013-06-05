package dbd.frontend.controller;

import dbd.model.Assignment;
import dbd.model.Student;
import dbd.model.StudentAssignment;
import dbd.model.SubmissionDocument;
import dbd.model.User;
import dbd.service.AssignmentService;
import dbd.service.SubmissionDocumentService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.bson.types.ObjectId;
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
    
    @Autowired
    private SubmissionDocumentService documentService;
    
    @RequestMapping(value = "/assignments", method = RequestMethod.GET)
    public String viewAssignments(Model model) {

        List<Assignment> assignments = assignService.getAllAssignments();
        assignments.add(new Assignment());
        model.addAttribute("assignments", assignments);
            return "assignments/viewAssignments";

    }
    
    @RequestMapping(value = "/assignments/{id}", method = RequestMethod.GET)
    public String editAssignment(Model model, @PathVariable ObjectId id) {

        Assignment assignment=null;
        try{
            assignment = (Assignment) assignService.getAssignment(id);
        }catch(Exception e){
            
        }
        model.addAttribute("assignment", assignment);
            return "assignments/editAssignment";

    }
    
    @RequestMapping(value = "/assignments/{id}", method = RequestMethod.POST)
    public String editAssignment(@ModelAttribute("assignment") Assignment assignment, BindingResult result,Model model,@PathVariable ObjectId id) {   
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
    
    @RequestMapping(value = "/assignments/upload/{id}", method = RequestMethod.GET)
    public String uploadAssignment(Model model, @PathVariable ObjectId id) {

        Assignment assignment=null;
        try{
            assignment = (Assignment) assignService.getAssignment(id);
        }catch(Exception e){
            
        }
        model.addAttribute("assignment", assignment);
            return "assignments/uploadAssignment";

    }
    
    @RequestMapping(value = "/assignments/upload/{id}", method = RequestMethod.POST)
    public String updateAssignment(@ModelAttribute("assignment") Assignment assignment, BindingResult result,Model model,@PathVariable ObjectId id,HttpSession session) {   
        User user = (User)session.getAttribute("user");
        if(user instanceof Student)
        {
            StudentAssignment studAss = new StudentAssignment();
            studAss.setAssignment(assignment);
            studAss.setDescription("description din pagina");
            Student student = (Student) user;
            studAss.setStudent(student);
            StudentAssignment savedSA = assignService.saveStudentAssignment(studAss);
            SubmissionDocument document = new SubmissionDocument();
            document.setName("numa din model");
            document.setPath("path din model");
            document.setDescription("nimic");
            documentService.saveSubmissionDocument(savedSA.getId(), document);
            
            
            return "redirect:/assignments/chooseAssignments";
        }
        return "redirect:/assignments/"+id;
    }
}
