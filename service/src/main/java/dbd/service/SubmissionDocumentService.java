package dbd.service;

import java.util.List;
import dbd.model.SubmissionDocument;
import org.bson.types.ObjectId;

/**
 * Use this interface instead of the Impl.
 *
 * Add methods on this interface and then implement on the corresponding Impl.
 */
public interface SubmissionDocumentService {

    public List<SubmissionDocument> getAllSubmissionDocuments(ObjectId id);

    public List<SubmissionDocument> getSubmissionDocumentByName(String name);
    
    public SubmissionDocument saveSubmissionDocument(SubmissionDocument document);

    public boolean storeFile(String path, String fileName);
    
    public boolean retrieveFile(String fileName);

    public void deleteFile(String fileName);
}
