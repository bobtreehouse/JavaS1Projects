package com.company.dao;



import com.company.dao.AuthorDao;
import com.company.dao.BookDao;
import com.company.dao.PublisherDao;
import com.company.model.Author;
import com.company.model.Book;
import com.company.model.Publisher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorJdbcTemplateImplTest {

    @Autowired
    private AuthorDao AuthorDao;
    @Autowired
    private BookDao BookDao;
    @Autowired
    private PublisherDao PublisherDao;

    @Before
    public void setUp() throws Exception {

        List<Book> bList = BookDao.getAllBooks();

        bList.stream()

                .forEach(book -> BookDao.getAllBooks());


        List<Publisher> pList = PublisherDao.getAllPublishers();

        pList.stream()
                .forEach(publisher -> PublisherDao.deletePublisher(publisher.getPublisher_id()));

        List<Author> aList = AuthorDao.getAllAuthors();

        aList.stream()
                .forEach(author -> AuthorDao.deleteAuthor(author.getAuthor_id()));

    }

    @Test
    public void addGetDeleteAuthor() {
        Author author = new Author();
        author.setAuthor_id(67891);
        author.setFirst_name("Peter");
        author.setLast_name("Benchley");
        author.setStreet("Highview Ave");
        author.setCity("New Bergenfield");
        author.setState("NJ");
        author.setPostal_code("07621");
        author.setPhone("201-387-7031");
        author.setEmail("BigShark@Jaws.com");

        author = AuthorDao.addAuthor(author);
        Author author1 = AuthorDao.getAuthor(author.getAuthor_id());

        assertEquals(author1, author);

        AuthorDao.deleteAuthor(author.getAuthor_id());

        author1 = AuthorDao.getAuthor(author.getAuthor_id());

        assertNull(author1);


    }

    @Test
    public void getAllAuthors() {
        Author author = new Author();

        author.setFirst_name("Stephen");
        author.setLast_name("Strange");
        author.setStreet("Bleecker Street");
        author.setCity("New York");
        author.setState("New York");
        author.setPostal_code("12344");
        author.setPhone("555-919-9111");
        author.setEmail("DoctorStrange@SanctumSanctorum.com");

        AuthorDao.addAuthor(author);

        author = new Author();
        author.setFirst_name("Jasper");
        author.setLast_name("Sitwell");
        author.setStreet("Mjolnir Street");
        author.setCity("Shield City");
        author.setState("New Jersey");
        author.setPostal_code("22222");
        author.setPhone("481-516-2342");
        author.setEmail("JSitwell@SHIELD.com");

        AuthorDao.addAuthor(author);

        List<Author> authorList = AuthorDao.getAllAuthors();

        assertEquals(authorList.size(), 2);

    }

    @Test
    public void updateAuthor() {
        Author author = new Author();
        author.setFirst_name("Stephen");
        author.setLast_name("Strange");
        author.setStreet("Bleecker Street");
        author.setCity("New York");
        author.setState("New York");
        author.setPostal_code("12344");
        author.setPhone("555-919-9111");
        author.setEmail("DoctorStrange@SanctumSanctorum.com");

        author = AuthorDao.addAuthor(author);

        author.setFirst_name("Karl");
        author.setLast_name("Mordo");
        author.setStreet("Walt Disney Street");
        author.setCity("Orlando");
        author.setState("Nevada");

        AuthorDao.updateAuthor(author);

        Author author2 = AuthorDao.getAuthor(author.getAuthor_id());

        assertEquals(author2, author);
    }


}