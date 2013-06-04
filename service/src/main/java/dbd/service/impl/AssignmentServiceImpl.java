package dbd.service.impl;

import java.util.List;
import dbd.model.Assignment;
import dbd.model.Student;
import dbd.model.StudentAssignment;
import dbd.model.SubmissionDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dbd.repository.AssignmentRepository;
import dbd.repository.StudentAssignmentRepository;
import dbd.repository.SubmissionDocumentRepository;
import dbd.service.AssignmentService;
import org.bson.types.ObjectId;

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
    
    public List<Assignment> getAssignmentByName(String name) {
        return assignmentRepository.findByName(name);
    }
        
    public Assignment getAssignment(ObjectId id) {
        return assignmentRepository.findOne(id);
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }
    
    public StudentAssignment getStudentAssignment(Student student, Assignment assignment) {
        return studentAssignmentRepository.findOneByStudentAndAssignment(student, assignment);
    }

    public StudentAssignment saveStudentAssignment(StudentAssignment studentAssignment) {
        List<SubmissionDocument> docs = studentAssignment.getDocuments();   
        List<SubmissionDocument> savedDocs = 
                (List<SubmissionDocument>) submissionDocumentRepository.save(docs);
        studentAssignment.setDocuments(savedDocs);
        return studentAssignmentRepository.save(studentAssignment);
    }
    
    public StudentAssignment addStudentGradeOnAssignment(StudentAssignment studentAsign,int grade){
    	 List<SubmissionDocument> docs = studentAsign.getDocuments();   
         List<SubmissionDocument> savedDocs = 
                 (List<SubmissionDocument>) submissionDocumentRepository.save(docs);
         studentAsign.setGrade(grade);
         return studentAssignmentRepository.save(studentAsign);
    }

}
