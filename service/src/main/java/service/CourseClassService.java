/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Course;
import model.CourseClass;
import model.CourseType;

/**
 *
 * @author Alex Marchis
 */
public interface CourseClassService {
    
    public List<CourseClass> getCourseClassesFromCourseOfType(Course course,
            CourseType courseType);
    
    public CourseClass saveCourseClass(CourseClass courseClass);
}
