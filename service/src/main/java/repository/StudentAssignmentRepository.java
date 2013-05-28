package repository;

import model.Assignment;
import model.Student;
import model.StudentAssignment;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface StudentAssignmentRepository extends PagingAndSortingRepository<StudentAssignment, ObjectId> {

    public List<StudentAssignment> findByAssignment(Assignment assignment);

    public List<StudentAssignment> findByAssignment(Assignment assignment, Sort sort);

    public List<StudentAssignment> findByAssignmentId(ObjectId id);

    public List<StudentAssignment> findByAssignmentId(ObjectId id, Sort sort);

    public List<StudentAssignment> findByStudent(Student student);

    public List<StudentAssignment> findByStudent(Student student, Sort sort);

    public List<StudentAssignment> findByStudentId(ObjectId id);

    public List<StudentAssignment> findByStudentId(ObjectId id, Sort sort);

    public List<StudentAssignment> findBySubmission(Date date);

    public List<StudentAssignment> findBySubmission(Date date, Sort sort);

    public List<StudentAssignment> findBySubmissionBefore(Date date);

    public List<StudentAssignment> findBySubmissionBefore(Date date, Sort sort);

    public List<StudentAssignment> findBySubmissionAfter(Date date);

    public List<StudentAssignment> findBySubmissionAfter(Date date, Sort sort);

    public List<StudentAssignment> findBySubmissionBetween(Date start, Date end);

    public List<StudentAssignment> findBySubmissionBetween(Date start, Date end, Sort sort);

    public List<StudentAssignment> findByGrade(int grade);

    public List<StudentAssignment> findByGrade(int grade, Sort sort);

    public List<StudentAssignment> findByGradeGreaterThan(int grade);

    public List<StudentAssignment> findByGradeGreaterThan(int grade, Sort sort);

    public List<StudentAssignment> findByGradeLessThan(int grade);

    public List<StudentAssignment> findByGradeLessThan(int grade, Sort sort);

    public List<StudentAssignment> findByGradeBetween(int start, int end);

    public List<StudentAssignment> findByGradeBetween(int start, int end, Sort sort);


}
