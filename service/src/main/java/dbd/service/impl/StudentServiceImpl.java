package dbd.service.impl;

import java.util.List;
import dbd.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dbd.repository.StudentRepository;
import dbd.service.StudentService;
import java.util.Iterator;
import org.bson.types.ObjectId;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public List<Student> deleteStudent(Student student) {
        
        List<Student> students = (List<Student>) studentRepository.findAll();
        
        Iterator it = students.iterator();
        while (it.hasNext()) {
            Student st = (Student) it.next();
            if (st.getMatriculationNumber().equals(student.getMatriculationNumber())) {
                students.remove(st);
                break;
            }
        }
        return students;
    }
    
    


}
