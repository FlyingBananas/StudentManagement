package repository;

import model.Course;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CourseRepository extends PagingAndSortingRepository<Course, ObjectId> {

    Course findOneByYearAndName(int year, String name);

    List<Course> findByYear(int year);

    List<Course> findByYear(int year, Sort sort);



}
