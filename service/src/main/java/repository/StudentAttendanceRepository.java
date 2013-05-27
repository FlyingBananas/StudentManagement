package repository;

import model.CourseClass;
import model.Student;
import model.StudentAttendance;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentAttendanceRepository extends PagingAndSortingRepository<StudentAttendance,ObjectId> {

    public List<StudentAttendance> findByStudent(Student student);

    public List<StudentAttendance> findByStudent(Student student, Sort sort);

    public List<StudentAttendance> findByStudentId(ObjectId id);

    public List<StudentAttendance> findByStudentId(ObjectId id, Sort sort);

    public List<StudentAttendance> findByCourseClass(CourseClass courseClass);

    public List<StudentAttendance> findByCourseClass(CourseClass courseClass, Sort sort);

    public List<StudentAttendance> findByCourseClassId(ObjectId id);

    public List<StudentAttendance> findByCourseClassId(ObjectId id, Sort sort);
}
