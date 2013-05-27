package repository;


import model.Teacher;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, ObjectId>{

    Teacher findOneByLoginUsernameAndLoginPassword(String username, String password);

    List<Teacher> findByName(String name);

    List<Teacher> findByName(String name, Sort sort);
}
