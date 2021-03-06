/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbd.service.impl;

import java.util.List;
import dbd.model.Course;
import dbd.model.Student;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dbd.repository.CourseRepository;
import dbd.service.CourseService;

/**
 *
 * @author Alex Marchis
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course getCourse(ObjectId id) {
        return courseRepository.findOne(id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course enrollStudentInCourse(Student student, Course course) {
        course.getStudents().add(student);
        return courseRepository.save(course);
    }

    
}
