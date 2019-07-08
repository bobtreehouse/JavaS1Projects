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

import java.util.List;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookJdbcTemplateImplTest {

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


    @After
    public void tearDown() throws Exception{

    }


    @Test
    public void addGetDeleteBook() {

        Book book = new Book();
        book.setBook_id(1234);
        book.setIsbn(12345);
        book.setPublish_date(LocalDate.of(2019, 11, 10));
        book.setAuthor_id(1122445);
        book.setTitle("Jaws 2");
        book.setPublisher_id(3456);
        book.setPrice(10.50);

        book = BookDao.addBook(book);

        Author author = new Author();
        author.setAuthor_id(67891);
        author.setFirst_name("Peter");
        author.setLast_name("Benchley");
        author.setStreet("Highview Ave");
        author.setCity("Bergenfield");
        author.setState("NJ");
        author.setPostal_code("07621");
        author.setPhone("201-387-7031");
        author.setEmail("BigShark@Jaws.com");

        author = AuthorDao.addAuthor(author);

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

        Book book2 = BookDao.getBook((book.getBook_id()));

        assertEquals(book2, book);


    }



    @Test
    public void updateBook() {

        Book book = new Book();
        book.setIsbn(123 - 1 - 4567 - 9876 - 1);
        book.setPublish_date(LocalDate.of(2019, 11, 10));
        book.setAuthor_id(1122445);
        book.setTitle("Jaws 2");
        book.setPublisher_id(3456);
        book.setPrice(10.50);

        book = BookDao.addBook(book);

        Author author = new Author();
        author.setAuthor_id(67891);
        author.setFirst_name("Peter");
        author.setLast_name("Benchley");
        author.setStreet("Highview Ave");
        author.setCity("Bergenfield");
        author.setState("NJ");
        author.setPostal_code("07621");
        author.setPhone("201-387-7031");
        author.setEmail("BigShark@Jaws.com");

        author = AuthorDao.addAuthor(author);

        Publisher publisher = new Publisher();

        publisher.setPublisher_id(54321);
        publisher.setName("Random House");
        publisher.setStreet2("Park Ave");
        publisher.setCity2("New York");
        publisher.getState2("NY");
        publisher.getPostal_code2("10011");
        publisher.getPhone2("212-555-1212");
        publisher.getEmail2("CrazyPub@Pubs.com");

        Book book2 = BookDao.getBook((book.getBook_id()));

        assertEquals(book2, book);

    }
        @Test
        public void getAllBooks() {

            Book book = new Book();
            book.setIsbn(123-1-4567-9876-1);
            book.setPublish_date(LocalDate.of(2019, 11, 10));
            book.setAuthor_id(1122445);
            book.setTitle("Jaws 2");
            book.setPublisher_id(3456);
            book.setPrice(10.50);

            book = BookDao.addBook(book);

            BookDao.addBook(book);

            Book book2 = new Book();
            book.setIsbn(123-1-4567-1234-1);
            book.setPublish_date(LocalDate.of(2012, 11, 10));
            book.setAuthor_id(1122455);
            book.setTitle("IronMan");
            book.setPublisher_id(3456);
            book.setPrice(12.50);


            BookDao.addBook(book2);

            List<Book> bookList = BookDao.getAllBooks();

            assertEquals(bookList.size(), 2);
        }


}
