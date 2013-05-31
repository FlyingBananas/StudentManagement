/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceTests;

import java.util.List;
import model.Course;
import org.bson.types.ObjectId;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import service.CourseService;

/**
 *
 * @author Alex Marchis
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CourseServiceTests {
    
    @Autowired
    CourseService courseService;
    
    @Test
    public void getAllCourses_WhenCalled_ReturnsCourses()
    {
        List<Course> courses = courseService.getAllCourses();
        
        Assert.notEmpty(courses);
    }
    
    @Test
    public void getCourse_GivenIdFromList_ReturnsCourse()
    {
        List<Course> courses = courseService.getAllCourses();
        ObjectId id = courses.get(0).getId(); 
        Course course = courseService.getCourse(id);
        Assert.notNull(course);
    }
    
    @Test
    @Ignore
    public void saveCourse_GivenCourse_SavesCourse()
    {
        Course course = new Course();
        course.setName("DataBases");
        course.setYear(2013);
        
        Course savedCourse = courseService.saveCourse(course);
        
        Assert.notNull(course.getId());
    }
    
    @Test
    @Ignore
    public void saveCourse_GivenExistingCourse_UpdatesCourse()
    {
        List<Course> courses = courseService.getAllCourses();
        Course course = courses.get(0); 
        ObjectId idBefore = course.getId();
        course.setName("DBD");
        
        Course updatedCourse = courseService.saveCourse(course);
        
        Assert.isTrue("DBD" == updatedCourse.getName());
        Assert.isTrue(idBefore == updatedCourse.getId());
    }
}
