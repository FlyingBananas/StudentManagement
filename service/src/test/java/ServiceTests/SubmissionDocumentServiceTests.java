package ServiceTests;

import dbd.model.StudentAssignment;
import dbd.service.*;
import java.util.List;
import dbd.model.SubmissionDocument;
import dbd.repository.StudentAssignmentRepository;
import dbd.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SubmissionDocumentServiceTests {

    @Autowired
    SubmissionDocumentService submissionDocumentService;
    
    @Autowired
    StudentAssignmentRepository studentAssignmentRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
    @Test
    @Ignore
    public void getAllSubmissionDocuments_ByUsingAnId() {
        List<SubmissionDocument> submissionDocuments;
        submissionDocuments = submissionDocumentService.getAllSubmissionDocuments(new ObjectId("1234567890"));
        
        Assert.notEmpty(submissionDocuments);
    }
    
    @Test
    @Ignore
    public void saveSubmissionDocument_GivenFile_StoresFile() {
        List<StudentAssignment> assignments = 
                (List<StudentAssignment>) studentAssignmentRepository.findAll();
        StudentAssignment assignment = assignments.get(0);
        SubmissionDocument document = new SubmissionDocument();
        document.setDescription("nik");
        document.setName("TestFile");
        document.setPath("D:\\TestFile.doc");
        
        SubmissionDocument saveddoc = 
                submissionDocumentService.saveSubmissionDocument(assignment.getId(),document);
            
        Assert.notNull(saveddoc.getId());
    }

//    @Test
//    public List<SubmissionDocument> getSubmissionDocumentByName(String name);

    
}
