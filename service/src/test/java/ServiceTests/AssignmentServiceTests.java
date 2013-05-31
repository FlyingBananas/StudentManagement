/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Assignment;
import model.Student;
import model.StudentAssignment;
import model.SubmissionDocument;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import repository.StudentRepository;
import repository.SubmissionDocumentRepository;
import service.AssignmentService;

/**
 *
 * @author Alex Marchis
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AssignmentServiceTests {
    @Autowired
    AssignmentService assignmentService;
    
    @Autowired
    StudentRepository studentRepository;
    
    
    
    @Test
    public void getAllAssignments_WhenCalled_RetrievesListOfAssignments(){
        List<Assignment> assignments;
        assignments = assignmentService.getAllAssignments();
        
        Assert.notEmpty(assignments);
    }
    
    @Test
    @Ignore
    public void saveAssignment_WhenCalled_SavesAssignemnt(){
        Assignment a = new Assignment();
        a.setDeadline(new Date());
        a.setDescription("Do this shieta");
        a.setName("Crazy ass");
        
        Assignment savedAss = assignmentService.saveAssignment(a);
        
        Assert.notNull(savedAss.getId());
        
        
    }
    
    @Test
    public void saveStudentAssignment_WhenCalled_SavesAssignemnt(){
        StudentAssignment studentAssignment = new StudentAssignment();
        
        SubmissionDocument document = new SubmissionDocument();
        document.setDescription("Doc for crazy ass assignment");
        document.setName("CrazyFile");
        document.setPath("no ma");
   
        List<SubmissionDocument> documents = new ArrayList<SubmissionDocument>();
        documents.add(document);
        
        Assignment a = assignmentService.getAssignmentByName("Crazy ass").get(0);     
        
        Student s = studentRepository.findByName("Feri").get(0);
        
        studentAssignment.setAssignment(a);
        studentAssignment.setDescription("I did good");
        studentAssignment.setDocuments(documents);
        studentAssignment.setStudent(s);
        studentAssignment.setSubmission(new Date());
        
         
        StudentAssignment savedSA = assignmentService.saveStudentAssignment(studentAssignment);
        
        Assert.notNull(savedSA.getId());

    }
}