package dbd.service;

import java.util.List;
import dbd.model.Student;
import org.bson.types.ObjectId;

/**
 * Use this interface instead of the Impl.
 *
 * Add methods on this interface and then implement on the corresponding Impl.
 */
public interface StudentService {

    public List<Student> getAllStudents();
    
    public Student getStudent(String id);
    
    public Student saveStudent(Student student);
    
    public List<Student> deleteStudent(Student student);

}
