package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoTest {


    @Autowired
    protected PostDao dao;

    @Before
    public void setUp() throws Exception {

        // clean out the test db
        List<Post> postList = dao.getAllPosts();
        postList.stream().forEach(post -> dao.deletePost(post.getPostID()));
    }


    @Test
    public void addAndGetPost() {

        Post post = new Post();

        //post.setPostID(1);
        post.setPostDate(LocalDate.of(2019, 07, 30));
        post.setPosterName("bobt");
        post.setPost("I am busy building the Hyperloop");
        //Post from DAO.Add
        post = dao.addPost(post);
        //Post from DAO.GET
        Post post2 = dao.getPost(post.getPostID());

        //ASSERTING
        assertEquals(post, post2);

        dao.deletePost(post.getPostID());

        post2 = dao.getPost(post.getPostID());

        assertNull(post2);
    }


    @Test
    public void getAllPosts() {
        Post post = new Post();

        post.setPostDate(LocalDate.of(2019, 07, 30));
        post.setPosterName("bobt");
        post.setPost("I am busy building the Hyperloop");

        dao.addPost(post);

        post = new Post();

        post.setPostDate(LocalDate.of(2019, 8, 02));
        post.setPosterName("bobt");
        post.setPost("Yes, I know Hyperloop and Hadoop are two different things!");

        dao.addPost(post);
        List<Post> taskList = dao.getAllPosts();

        assertEquals(taskList.size(), 2);

    }


}