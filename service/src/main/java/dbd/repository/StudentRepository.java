package dbd.repository;


import dbd.model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student,String> {

    public Student findOneByMatriculationNumber(String matriculationNumber);

    public List<Student> findByName(String name);

    public List<Student> findByName(String name, Sort sort);

    public Student findOneByLoginUsernameAndLoginPassword(String username, String password);
}
