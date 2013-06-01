package service;

import java.util.List;
import model.Assignment;
import model.Student;
import model.StudentAssignment;

/**
 * Use this interface instead of the Impl.
 *
 * Add methods on this interface and then implement on the corresponding Impl.
 */
public interface AssignmentService {

    public List<Assignment> getAllAssignments();
    
    public List<Assignment> getAssignmentByName(String name);
    
    public Assignment saveAssignment(Assignment assignment);
    
    public StudentAssignment getStudentAssignment(Student student, Assignment assignment);
    
    public StudentAssignment saveStudentAssignment(StudentAssignment studentAssignment);
    public StudentAssignment addStudentGradeOnAssignment(StudentAssignment studentAsign,int grade);
}
