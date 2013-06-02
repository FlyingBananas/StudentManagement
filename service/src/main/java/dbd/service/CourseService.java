/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbd.service;

import java.util.List;
import dbd.model.Course;
import dbd.model.Student;

import org.bson.types.ObjectId;

/**
 *
 * @author Alex Marchis
 */
public interface CourseService {
    
    public List<Course> getAllCourses();
    
    public Course getCourse(ObjectId id);
    
    public Course saveCourse(Course course);
    
    public Course enrollStudentInCourse(Student student, Course course);
    
 
}
