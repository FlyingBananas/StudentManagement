package service.impl;

import java.util.List;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;
import service.StudentService;

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
    
    


}
