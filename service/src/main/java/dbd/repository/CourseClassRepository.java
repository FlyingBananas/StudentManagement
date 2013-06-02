package dbd.repository;

import dbd.model.Course;
import dbd.model.CourseClass;
import dbd.model.CourseType;
import dbd.model.Teacher;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

public interface CourseClassRepository extends PagingAndSortingRepository<CourseClass,ObjectId> {

    public List<CourseClass> findByType(CourseType type);

    public List<CourseClass> findByType(CourseType type, Sort sort);

    public List<CourseClass> findByClassDate(Date date);

    public List<CourseClass> findByClassDate(Date date, Sort sort);

    public List<CourseClass> findByClassDateBefore(Date date);

    public List<CourseClass> findByClassDateBefore(Date date, Sort sort);

    public List<CourseClass> findByClassDateAfter(Date date);

    public List<CourseClass> findByClassDateAfter(Date date, Sort sort);

    public List<CourseClass> findByClassDateBetween(Date start, Date end);

    public List<CourseClass> findByClassDateBetween(Date start, Date end, Sort sort);

    public List<CourseClass> findByTeacher(Teacher teacher);

    public List<CourseClass> findByTeacher(Teacher teacher, Sort sort);

    public List<CourseClass> findByTeacherId(ObjectId objectId);

    public List<CourseClass> findByTeacherId(ObjectId objectId, Sort sort);

    public List<CourseClass> findByCourse(Course course);

    public List<CourseClass> findByCourse(Course course, Sort sort);

    public List<CourseClass> findByCourseId(ObjectId objectId);

    public List<CourseClass> findByCourseId(ObjectId objectId, Sort sort);
    
    public List<CourseClass> findByCourseAndType(Course course, CourseType type);

}
