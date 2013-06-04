package dbd;

import com.mongodb.gridfs.GridFSDBFile;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.junit.Ignore;

/**
 * Created with IntelliJ IDEA.
 * User: Xenosky
 * Date: 6/3/13
 * Time: 7:49 PM
  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GridFSTemplateTest {

    @Autowired
    GridFsTemplate template;

    @Test
    @Ignore
    public void testGridFSOperations() throws IOException {

        /*
            Store file
         */
        InputStream file = new FileInputStream("D:\\Test_Mongo.doc");
        String nameInMongo = "test_doc_file";

        List<GridFSDBFile> allFiles = template.find(null);
        int sizeBefore = allFiles.size();

        template.store(file, nameInMongo);

        allFiles = template.find(null);
        int sizeAfter = allFiles.size();

        Assert.assertEquals(sizeAfter, sizeBefore + 1);

        /*
         *  Retrieve and write file.
         */
        Query query = new Query();
        query.addCriteria(Criteria.where("filename").is("test_doc_file"));
        GridFSDBFile gridFSDBFile = template.findOne(query);
        gridFSDBFile.writeTo("D:\\result_mongo.doc");

        /*
            Delete file
         */
        template.delete(query);

        allFiles = template.find(null);
        sizeAfter = allFiles.size();

        Assert.assertEquals(sizeAfter, sizeBefore);
    }
}
