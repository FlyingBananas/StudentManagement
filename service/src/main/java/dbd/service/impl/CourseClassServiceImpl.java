/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbd.service.impl;

import java.util.ArrayList;
import java.util.List;
import dbd.model.Course;
import dbd.model.CourseClass;
import dbd.model.CourseType;
import dbd.model.Student;
import dbd.model.StudentAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dbd.repository.CourseClassRepository;
import dbd.repository.StudentAttendanceRepository;
import dbd.service.CourseClassService;
import org.bson.types.ObjectId;

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
    
    public CourseClass getCourseClass(ObjectId id) {
        return courseClassRepository.findOne(id);
    }

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
    
    public List<StudentAttendance> addStudentAttendancesForCourseClass(Student student,CourseClass course){
    	 List<StudentAttendance> attendances = (List<StudentAttendance>) studentAttendanceRepository.findAll();
    	StudentAttendance attendaceStudent=new StudentAttendance();
    	attendaceStudent.setStudent(student);
    	attendaceStudent.setCourseClass(course);
    	 
    	 attendances.add(attendaceStudent);
    	 
    	 return (List<StudentAttendance>) studentAttendanceRepository.save(attendances);
    	
    }

    
}
