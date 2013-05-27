package repository;


import model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student,String> {

    Student findOneByMatriculationNumber(String matriculationNumber);

    List<Student> findByName(String name);

    List<Student> findByName(String name, Sort sort);

    Student findOneByLoginUsernameAndLoginPassword(String username, String password);
}
