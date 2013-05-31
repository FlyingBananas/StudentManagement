package repository;

import model.Course;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CourseRepository extends PagingAndSortingRepository<Course, ObjectId> {

    public Course findOneByYearAndName(int year, String name);

    public List<Course> findByYear(int year);

    public List<Course> findByYear(int year, Sort sort);

    public List<Course> findByYearGreaterThan(int year);

    public List<Course> findByYearGreaterThan(int year, Sort sort);

    public List<Course> findByYearLessThan(int year);

    public List<Course> findByYearLessThan(int year, Sort sort);

    public List<Course> findByYearBetween(int startngYear, int endYear);

    public List<Course> findByYearBetween(int startngYear, int endYear, Sort sort);

}
