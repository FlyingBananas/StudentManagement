package dbd;

import model.LoginDetails;
import model.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import service.StudentService;

/**
 * Created with IntelliJ IDEA.
 * User: Xenosky
 * Date: 5/27/13
 * Time: 6:39 PM
 */
///////
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentTest {
    
    @Autowired
    StudentRepository studentRepository;

    @Test
    @Ignore
    public void doSomething() {
        Student student = new Student();
        student.setName("Feri");
        student.setMatriculationNumber("1234423232");

        studentRepository.save(student);

        List<Student> studentList = studentRepository.findByName("Feri");

        Assert.notEmpty(studentList);
    }
    


    @Test
    @Ignore
    public void testRetrieveStudent() {

        String matriculationNumber = "1234423232";
        Student student = studentRepository.findOneByMatriculationNumber(matriculationNumber);

        Assert.notNull(student);
    }

    @Test
    @Ignore
    public void testInsertManyStudents() {

        List<Student> students = new ArrayList<Student>();

        Student student = new Student();
        student.setName("Bogdan");
        student.setMatriculationNumber("1234");
        students.add(student);

        Student student2 = new Student();
        student2.setName("Alexandra");
        student2.setMatriculationNumber("2345");
        students.add(student2);

        studentRepository.save(students);

        students = (List<Student>) studentRepository.findAll(new Sort(Sort.Direction.DESC, "name"));

        Assert.notEmpty(students);

    }

    @Test
    @Ignore
    public void testLogin() {

        Student student2 = new Student();
        student2.setName("Alexandra");
        student2.setMatriculationNumber("12345");
        student2.setLogin(new LoginDetails("ale", "xandra"));

        studentRepository.save(student2);

        Student result = studentRepository.findOneByLoginUsernameAndLoginPassword("ale", "xandra");

        Assert.notNull(result);
    }


}
