/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.CourseClass;
import model.CourseType;
import model.Student;
import model.StudentAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CourseClassRepository;
import repository.StudentAttendanceRepository;
import service.CourseClassService;

/**
 *
 * @author Alex Marchis
 */
@Service
@Transactional
public class CourseClassServiceImpl implements CourseClassService {
    
    @Autowired
    CourseClassRepository courseClassRepository;
    
    @Autowired
    StudentAttendanceRepository studentAttendanceRepository;

    public List<CourseClass> getCourseClassesFromCourseOfType(Course course, 
            CourseType courseType) {
        return courseClassRepository.findByCourseAndType(course, courseType);
    }
    
    public List<StudentAttendance> getStudentAttendancesForCourseClass(CourseClass courseClass) {
        return studentAttendanceRepository.findByCourseClass(courseClass);
    }
    
    public List<StudentAttendance> saveStudentAttendancesForCourseClass(
            CourseClass courseClass, List<Student> students) {
        
        List<StudentAttendance> attendances = new ArrayList<StudentAttendance>();
        for(Student student : students){
            StudentAttendance at = new StudentAttendance();
            at.setCourseClass(courseClass);
            at.setStudent(student);
            attendances.add(at);
        }
        
        return (List<StudentAttendance>) studentAttendanceRepository.save(attendances);
    }

    public CourseClass saveCourseClass(CourseClass courseClass) {
        return courseClassRepository.save(courseClass);
    }    
}
