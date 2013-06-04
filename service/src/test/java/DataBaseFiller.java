
import dbd.model.Assignment;
import dbd.model.Course;
import dbd.model.CourseClass;
import dbd.model.CourseType;
import dbd.model.LoginDetails;
import dbd.model.Student;
import dbd.model.StudentAssignment;
import dbd.model.StudentAttendance;
import dbd.model.SubmissionDocument;
import dbd.model.Teacher;
import dbd.repository.AssignmentRepository;
import dbd.repository.CourseClassRepository;
import dbd.repository.CourseRepository;
import dbd.repository.StudentAssignmentRepository;
import dbd.repository.StudentRepository;
import dbd.repository.SubmissionDocumentRepository;
import dbd.repository.TeacherRepository;
import dbd.service.AssignmentService;
import dbd.service.CourseClassService;
import dbd.service.CourseService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex Marchis
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DataBaseFiller {
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    AssignmentService assignmentService;
    
    
    @Autowired
    AssignmentRepository assignmentRepository;
    
    @Autowired
    SubmissionDocumentRepository submissionDocumentRepository;
    
    @Autowired
    StudentAssignmentRepository studentAssignmentRepository;
    
    @Autowired
    CourseClassRepository courseClassRepository;
    
    @Autowired
    TeacherRepository teacherRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    CourseClassService courseClassService;
    
    @Autowired
    CourseService courseService;
    
    @Test
    public void fillDataBase() {

        courseRepository.save(createCourses());
        studentRepository.save(createStudents());
        teacherRepository.save(createTeacher());
        courseClassRepository.save(createCourseClasses());
        saveStudentAttendances();
        assignmentRepository.save(createAssignments());
        studentAssignmentRepository.save(createStAss());

        Student result = studentRepository.findOneByLoginUsernameAndLoginPassword("ale", "xandra");

    }
    
    public List<CourseClass> createCourseClasses(){
        List<CourseClass> courseClasses = new ArrayList<CourseClass>();
        
        List<Teacher> ts =(List<Teacher>) teacherRepository.findAll();
        Teacher teacher = ts.get(0);
        
        Course course = courseService.getAllCourses().get(0);
        
        CourseClass courseClass = new CourseClass();
        Calendar calendar = new GregorianCalendar(2013, 07, 25);
        courseClass.setClassDate(calendar.getTime());
        courseClass.setCourse(course);
        courseClass.setTeacher(teacher);
        courseClass.setType(CourseType.LECTURE);
        courseClasses.add(courseClass);
        
        courseClass = new CourseClass();
        calendar = new GregorianCalendar(2013, 07, 30);
        courseClass.setClassDate(calendar.getTime());
        courseClass.setCourse(course);
        courseClass.setTeacher(teacher);
        courseClass.setType(CourseType.LECTURE);
        courseClasses.add(courseClass);
        
        course = courseService.getAllCourses().get(1);
        
        courseClass = new CourseClass();
        calendar = new GregorianCalendar(2013, 07, 25);
        courseClass.setClassDate(calendar.getTime());
        courseClass.setCourse(course);
        courseClass.setTeacher(teacher);
        courseClass.setType(CourseType.LECTURE);
        courseClasses.add(courseClass);
        
        courseClass = new CourseClass();
        calendar = new GregorianCalendar(2013, 07, 30);
        courseClass.setClassDate(calendar.getTime());
        courseClass.setCourse(course);
        courseClass.setTeacher(teacher);
        courseClass.setType(CourseType.LECTURE);
        courseClasses.add(courseClass);
        
        return courseClasses;
        
        
    }
    
    public Teacher createTeacher(){
        Teacher teacher = new Teacher();
        teacher.setName("Profu");
        teacher.setLogin(new LoginDetails("profu", "profu"));
        
        return teacher;
    }
    
    public List<Course> createCourses(){
        List<Course> courses = new ArrayList<Course>();
        Course course = new Course();
        course.setName("DataBases");
        course.setYear(2013);
        courses.add(course);
        
        course = new Course();
        course.setName("PP");
        course.setYear(2013);
        courses.add(course);
        
        course = new Course();
        course.setName("PM");
        course.setYear(2013);
        courses.add(course);
        
        course = new Course();
        course.setName("WTF");
        course.setYear(2013);
        courses.add(course);
        
        return courses;
        
    }
    
    public void saveStudentAttendances(){
        Course course = courseService.getAllCourses().get(0);
        CourseClass courseClass = 
                courseClassService.getCourseClassesFromCourseOfType(course, CourseType.LECTURE)
                                  .get(0);
        List<Student> students = (List<Student>)studentRepository.findAll(); 
        
        List<StudentAttendance> attendances = 
                courseClassService.saveStudentAttendancesForCourseClass(courseClass, students);
        
        Assert.notEmpty(attendances);
    }
    
    public List<Assignment> createAssignments(){
        List<Assignment> assignments = new ArrayList<Assignment>();
        
        Assignment a = new Assignment();
        a.setDeadline(new Date());
        a.setDescription("Do this shieta");
        a.setName("Crazy ass1");
        assignments.add(a);
        
        a = new Assignment();
        a.setDeadline(new Date());
        a.setDescription("Do this shieta");
        a.setName("Crazy ass2");
        assignments.add(a);
        
        a = new Assignment();
        a.setDeadline(new Date());
        a.setDescription("Do this shieta");
        a.setName("Crazy ass3");
        assignments.add(a);
        
        return assignments;
    }
    
    public List<StudentAssignment> createStAss(){
        List<StudentAssignment> studentass = new ArrayList<StudentAssignment>();
        
        StudentAssignment studentAssignment = new StudentAssignment();
        
        SubmissionDocument document = new SubmissionDocument();
        document.setDescription("Doc for crazy ass1 assignment");
        document.setName("CrazyFile1");
        document.setPath("no ma");
   
        List<SubmissionDocument> documents = new ArrayList<SubmissionDocument>();
        SubmissionDocument savedd = submissionDocumentRepository.save(document);
        documents.add(savedd);
        
        Assignment a = assignmentService.getAssignmentByName("Crazy ass1").get(0);     
        
        Student s = studentRepository.findByName("Alex").get(0);
        
        studentAssignment.setAssignment(a);
        studentAssignment.setDescription("I did good");
        studentAssignment.setDocuments(documents);
        studentAssignment.setStudent(s);
        studentAssignment.setSubmission(new Date());    
        
        studentass.add(studentAssignment);
        
        studentAssignment = new StudentAssignment();
        
        document = new SubmissionDocument();
        document.setDescription("Doc for crazy ass2 assignment");
        document.setName("CrazyFile2");
        document.setPath("no ma");
   
        documents = new ArrayList<SubmissionDocument>();
        savedd = submissionDocumentRepository.save(document);
        documents.add(savedd);
        
        a = assignmentService.getAssignmentByName("Crazy ass2").get(0);     
        
        studentAssignment.setAssignment(a);
        studentAssignment.setDescription("I did good");
        studentAssignment.setDocuments(documents);
        studentAssignment.setStudent(s);
        studentAssignment.setSubmission(new Date());  
        
        studentass.add(studentAssignment);
        
        return studentass;
    }
    
    public List<Student> createStudents(){
        List<Student> students = new ArrayList<Student>();
        Student student = new Student();
        student.setName("Alexandra");
        student.setMatriculationNumber("12345");
        student.setLogin(new LoginDetails("ale", "xandra"));
        
        students.add(student);
        
        student = new Student();
        student.setName("Alex");
        student.setMatriculationNumber("12123");
        student.setLogin(new LoginDetails("alex", "alex"));
        
        students.add(student);
        
        student = new Student();
        student.setName("Casi");
        student.setMatriculationNumber("167834");
        student.setLogin(new LoginDetails("casi", "casi"));
        
        students.add(student);
        
        student = new Student();
        student.setName("Ioana");
        student.setMatriculationNumber("167834");
        student.setLogin(new LoginDetails("ioana", "ioana"));
        
        students.add(student);
        
        student = new Student();
        student.setName("Mada");
        student.setMatriculationNumber("16454");
        student.setLogin(new LoginDetails("mada", "mada"));
        
        students.add(student);
        
        return students;
    }
}
