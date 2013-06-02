/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbd.service;

import java.util.List;
import dbd.model.Course;
import dbd.model.CourseClass;
import dbd.model.CourseType;
import dbd.model.Student;
import dbd.model.StudentAttendance;

/**
 *
 * @author Alex Marchis
 */
public interface CourseClassService {
    
    public List<CourseClass> getCourseClassesFromCourseOfType(Course course,
            CourseType courseType);
    
    public List<StudentAttendance> getStudentAttendancesForCourseClass(
            CourseClass courseClass); 
    
    public List<StudentAttendance> saveStudentAttendancesForCourseClass(
            CourseClass courseClass, List<Student> students);
    
    public CourseClass saveCourseClass(CourseClass courseClass);
    public List<StudentAttendance> addStudentAttendancesForCourseClass(Student student,CourseClass course);
}
