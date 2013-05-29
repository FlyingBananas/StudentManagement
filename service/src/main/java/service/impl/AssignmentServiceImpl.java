package service.impl;

import java.util.List;
import model.Assignment;
import model.StudentAssignment;
import model.SubmissionDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AssignmentRepository;
import repository.StudentAssignmentRepository;
import repository.SubmissionDocumentRepository;
import service.AssignmentService;

@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
    
    @Autowired
    AssignmentRepository assignmentRepository;
    
    @Autowired
    StudentAssignmentRepository studentAssignmentRepository;
    
    @Autowired
    SubmissionDocumentRepository submissionDocumentRepository;

    public List<Assignment> getAllAssignments() {
        return (List<Assignment>) assignmentRepository.findAll();
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public StudentAssignment saveStudentAssignment(StudentAssignment studentAssignment) {
        List<SubmissionDocument> docs = studentAssignment.getDocuments();   
        List<SubmissionDocument> savedDocs = 
                (List<SubmissionDocument>) submissionDocumentRepository.save(docs);
        studentAssignment.setDocuments(savedDocs);
        return studentAssignmentRepository.save(studentAssignment);
    }

    public List<Assignment> getAssignmentByName(String name) {
        return assignmentRepository.findByName(name);
    }
    
}
