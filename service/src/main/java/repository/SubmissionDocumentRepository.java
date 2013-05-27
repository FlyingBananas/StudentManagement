package repository;

import model.SubmissionDocument;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SubmissionDocumentRepository extends PagingAndSortingRepository<SubmissionDocument,ObjectId>{

    public List<SubmissionDocument> findByNameLike(String name);

    public List<SubmissionDocument> findByNameLike(String name, Sort sort);


}
