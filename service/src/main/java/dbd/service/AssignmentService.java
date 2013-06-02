package dbd.service;

import java.util.List;
import dbd.model.Assignment;
import dbd.model.Student;
import dbd.model.StudentAssignment;

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
