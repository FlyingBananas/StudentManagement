/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceTests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import model.Course;
import model.CourseClass;
import model.CourseType;
import model.LoginDetails;
import model.Student;
import model.StudentAttendance;
import model.Teacher;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import repository.CourseRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.CourseClassService;
import service.CourseService;

/**
 *
 * @author Alex Marchis
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CourseClassServiceTests {
    @Autowired
    CourseClassService courseClassService;
    
    @Autowired
    CourseService courseService;
    
    @Autowired
    TeacherRepository teacherRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    
    @Test
    public void getCourseClassesFromCourseOfType_GivenCourseAndType_ReturnsList()
    {
        Course course = courseService.getAllCourses().get(0);
        CourseType type = CourseType.LECTURE;
        
        List<CourseClass> classes = 
                courseClassService.getCourseClassesFromCourseOfType(course, type);
        
        Assert.notEmpty(classes);
    }
    
    @Test
    public void getStudentAttendancesForCourseClass_GivenCourseClass_ReturnsList(){
        Course course = courseService.getAllCourses().get(0);
        CourseClass courseClass = 
                courseClassService.getCourseClassesFromCourseOfType(course, CourseType.LECTURE)
                                  .get(0);
        
         List<StudentAttendance> attendances = 
                courseClassService.getStudentAttendancesForCourseClass(courseClass);
         
         Assert.notEmpty(attendances);
    }
    
    @Test
    @Ignore
    public void saveStudentAttendancesForCourseClass_GivenCourseClassAndStudents_SavesAttendences(){
        Course course = courseService.getAllCourses().get(0);
        CourseClass courseClass = 
                courseClassService.getCourseClassesFromCourseOfType(course, CourseType.LECTURE)
                                  .get(0);
        List<Student> students = (List<Student>)studentRepository.findAll(); 
        
        List<StudentAttendance> attendances = 
                courseClassService.saveStudentAttendancesForCourseClass(courseClass, students);
        
        Assert.notEmpty(attendances);
    }
    
    @Test
    @Ignore
    public void saveCourseClass_GivenCourseAndTeacher_SavesCourseClass()
    {
        List<Teacher> ts =(List<Teacher>) teacherRepository.findAll();
        Teacher teacher = ts.get(0);
        
        Course course = courseService.getAllCourses().get(0);
        
        CourseClass courseClass = new CourseClass();
        Calendar calendar = new GregorianCalendar(2013, 07, 25);
        courseClass.setClassDate(calendar.getTime());
        courseClass.setCourse(course);
        courseClass.setTeacher(teacher);
        courseClass.setType(CourseType.LECTURE);
        
        CourseClass savedClass = courseClassService.saveCourseClass(courseClass);
        
        Assert.notNull(savedClass.getId());
        
    }
    
    
    @Test
    public void testaddStudentAttendancesForCourseClass(){
    	
    	
    	List<Teacher> ts =(List<Teacher>) teacherRepository.findAll();
       
    	 Teacher teacher=new Teacher();
    	 teacher.setName("teacher");
    	 teacher.setLogin(new LoginDetails("teacherU","teacherP"));
    	 teacherRepository.save(teacher);
        
        
        Course course=new Course();
        course.setName("curs");
        course.setStudents(new ArrayList<Student>());
        course.setYear(2013);
        courseRepository.save(course);
        
        
        CourseClass courseClass = new CourseClass();
        Calendar calendar = new GregorianCalendar(2013, 07, 25);
        courseClass.setClassDate(calendar.getTime());
        courseClass.setCourse(course);
        courseClass.setTeacher(teacher);
        courseClass.setType(CourseType.LECTURE);
        courseClassService.saveCourseClass(courseClass);
        LoginDetails login=new LoginDetails("testUser","testPass");
        Student student=new Student();
        student.setName("test");
		student.setMatriculationNumber("321432423423");
		student.setLogin(login);	
        studentRepository.save(student);
        
        courseService.enrollStudentInCourse(student, course);
        Assert.notNull(courseService.getAllCourses());
        courseClassService.addStudentAttendancesForCourseClass(student, courseClass);
        Assert.notNull(courseClassService.getStudentAttendancesForCourseClass(courseClass));
        
        
     
        
    	
    }
    
    
    
}
