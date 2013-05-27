package repository;

import model.Assignment;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AssignmentRepository extends PagingAndSortingRepository<Assignment, ObjectId>{


}
