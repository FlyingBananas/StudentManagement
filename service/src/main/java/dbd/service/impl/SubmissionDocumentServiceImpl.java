package dbd.service.impl;

import com.mongodb.gridfs.GridFSDBFile;
import java.util.List;
import dbd.model.SubmissionDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dbd.repository.SubmissionDocumentRepository;
import dbd.service.SubmissionDocumentService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Service
@Transactional
public class SubmissionDocumentServiceImpl implements SubmissionDocumentService {

    @Autowired
    SubmissionDocumentRepository submissionDocumentRepository;
    @Autowired
    GridFsTemplate template;

    public List<SubmissionDocument> getAllSubmissionDocuments(ObjectId id) {
        return (List<SubmissionDocument>) submissionDocumentRepository.findByStudentAssignmentId(id);
    }

    public List<SubmissionDocument> getSubmissionDocumentByName(String name) {
        return (List<SubmissionDocument>) submissionDocumentRepository.findByName(name);

    }

    public boolean storeFile(String path, String fileName) {
        InputStream file;
        boolean success = false;
        try {
            file = new FileInputStream(path);
            String nameInMongo = fileName;
            if (template.store(file, nameInMongo) != null) {
                success = true;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SubmissionDocumentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return success;
        }

    }

    public boolean retrieveFile(String fileName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("filename").is("test_doc_file2"));
        GridFSDBFile gridFSDBFile = template.findOne(query);
        if (gridFSDBFile != null) {
            try {
                gridFSDBFile.writeTo("D:\\result_mongo.doc");
                return true;
            } catch (IOException ex) {
                Logger.getLogger(SubmissionDocumentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                return false;
            }
        }
        return false;
    }

    public void deleteFile(String fileName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("filename").is(fileName));
        template.delete(query);
    }
}
