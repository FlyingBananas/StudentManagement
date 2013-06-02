/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceTests;

import java.util.List;
import model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import repository.StudentRepository;
import service.StudentService;

/**
 * Created with IntelliJ IDEA.
 * User: Xenosky
 * Date: 5/27/13
 * Time: 6:39 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTests {
    
     @Autowired
    StudentService studentService;
    
    @Autowired
    StudentRepository studentRepository;
    
    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setName("Vlad");
        student.setMatriculationNumber("1234567890");
        
        Student savedStud = studentService.saveStudent(student);
        
        Assert.notNull(savedStud.getId());
    }
    
    @Test
    public void testGetAllStudents() {
        List<Student> students;
        
        students = studentService.getAllStudents();
        
        Assert.notEmpty(students);
        
        
    }
    
}
