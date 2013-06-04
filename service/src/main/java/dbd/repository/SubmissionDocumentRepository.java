package dbd.repository;

import dbd.model.StudentAssignment;
import dbd.model.SubmissionDocument;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SubmissionDocumentRepository extends PagingAndSortingRepository<SubmissionDocument,ObjectId>{

    public List<SubmissionDocument> findByName(String name);

    public List<SubmissionDocument> findByName(String name, Sort sort);
    
    public List<SubmissionDocument> findByStudentAssignment(StudentAssignment studentAssignment);
    
    public List<SubmissionDocument> findByStudentAssignment(StudentAssignment studentAssignment, Sort sort);
    
    public List<SubmissionDocument> findByStudentAssignmentId(ObjectId id);
    
    public List<SubmissionDocument> findByStudentAssignmentId(ObjectId id, Sort sort);
    
    public List<SubmissionDocument> findByNameAndStudentAssignmentId(String name, ObjectId id);
    
    public List<SubmissionDocument> findByNameOrStudentAssignmentId(String name, ObjectId id);
}
