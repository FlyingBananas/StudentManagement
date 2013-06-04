/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceTests;

import java.util.List;
import dbd.model.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import dbd.repository.StudentRepository;
import dbd.service.StudentService;

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
    @Ignore
    public void testInsertStudent() {
        Student student = new Student();
        student.setName("Vlad");
        student.setMatriculationNumber("1234567890");
        
        Student savedStud = studentService.saveStudent(student);
        
        Assert.notNull(savedStud.getId());
    }
    
    @Test
    @Ignore
    public void testGetAllStudents() {
        List<Student> students;
        
        students = studentService.getAllStudents();
        
        Assert.notEmpty(students);
        
        
    }
    
    @Test
    @Ignore
    public void testDeleteStudent() {
        
        List<Student> students;
        students = studentService.getAllStudents();
        
        List<Student> studentsAfter;
        studentsAfter =  studentService.deleteStudent(students.get(0));
        Assert.isTrue(students.size() - 1 == studentsAfter.size());
    }
    
}
