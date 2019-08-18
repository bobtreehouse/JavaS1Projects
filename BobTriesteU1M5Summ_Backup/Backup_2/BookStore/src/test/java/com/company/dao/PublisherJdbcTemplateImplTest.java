package com.company.dao;


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
public class PublisherJdbcTemplateImplTest {

    @Autowired
    protected AuthorDao AuthorDao;
    @Autowired
    protected BookDao BookDao;
    @Autowired
    protected PublisherDao PublisherDao;

    @Before
    public void setUp() throws Exception {
        List<Book> bList = BookDao.getAllBooks();

        bList.stream()
                .forEach(book -> BookDao.deleteBook(book.getBook_id()));

        List<Publisher> pList = PublisherDao.getAllPublishers();

        pList.stream()
                .forEach(publisher -> PublisherDao.deletePublisher(publisher.getPublisher_id()));

        List<Author> aList = AuthorDao.getAllAuthors();

        aList.stream()
                .forEach(author -> AuthorDao.deleteAuthor(author.getAuthor_id()));

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void addGetDeletePublisher() {

        Publisher publisher = new Publisher();

        publisher.setPublisher_id(54321);
        publisher.setName("Random House");
        publisher.setStreet2("Park Ave");
        publisher.setCity2("New York");
        publisher.getState2("New York");
        publisher.getPostal_code2("10011");
        publisher.getPhone2("212-555-1212");
        publisher.getEmail2("CrazyPub@Pubs.com");

        publisher = PublisherDao.addPublisher(publisher);

        Publisher publisher2 = PublisherDao.getPublisher(publisher.getPublisher_id());
        assertEquals(publisher, publisher2);

        PublisherDao.deletePublisher(publisher.getPublisher_id());
        publisher = PublisherDao.getPublisher((publisher.getPublisher_id()));

        assertNull(publisher2);
    }

    @Test

    public void updatePublisher() {

        Publisher publisher = new Publisher();

        publisher.setPublisher_id(54321);
        publisher.setName("Random House");
        publisher.setStreet2("Park Ave");
        publisher.setCity2("New York");
        publisher.getState2("NY");
        publisher.getPostal_code2("10011");
        publisher.getPhone2("212-555-1212");
        publisher.getEmail2("CrazyPub@Pubs.com");

        publisher = PublisherDao.addPublisher(publisher);

        publisher.setName("Big Book House");
        publisher.setPublisher_id(12345);
        publisher.setCity2("Jersey City");
        publisher.setState2("NJ");


        PublisherDao.updatePublisher(publisher);

        Publisher publisher1;
        publisher1 = PublisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher1, publisher);


    }
}








