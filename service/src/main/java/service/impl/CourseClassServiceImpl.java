/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.Course;
import model.CourseClass;
import model.CourseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CourseClassRepository;
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

    public List<CourseClass> getCourseClassesFromCourseOfType(Course course, 
            CourseType courseType) {
        return courseClassRepository.findByCourseAndType(course, courseType);
    }

    public CourseClass saveCourseClass(CourseClass courseClass) {
        return courseClassRepository.save(courseClass);
    }
    
}
