package ServiceTests;

import dbd.service.*;
import java.util.List;
import dbd.model.SubmissionDocument;
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
    StudentRepository studentRepository;
    
    @Test
    @Ignore
    public void getAllSubmissionDocuments_ByUsingAnId() {
        List<SubmissionDocument> submissionDocuments;
        submissionDocuments = submissionDocumentService.getAllSubmissionDocuments(new ObjectId("1234567890"));
        
        Assert.notEmpty(submissionDocuments);
    }

//    @Test
//    public List<SubmissionDocument> getSubmissionDocumentByName(String name);

    
}
