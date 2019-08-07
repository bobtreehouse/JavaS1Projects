package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
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
public class CommentDaoTest {

    @Autowired
    protected CommentDao dao;

    @Before
    public void setUp() throws Exception {

        // clean out the test db
        List<Comment> commentList = dao.getAllComments();
        commentList.stream().forEach(comment -> dao.deleteComment(comment.getCommentId()));
    }


    @Test
    public void addAndGetComment() {

        Comment comment = new Comment();


        comment.setCreateDate(LocalDate.of(2019, 07, 30));
        comment.setCommenterName("gregt");
        comment.setComment("Wow Bob that's Great!");
        //Comment from DAO.Add
        comment = dao.addComment(comment);
        //Comment from DAO.GET
        Comment comment2 = dao.getComment(comment.getCommentId());

        //ASSERTING
        assertEquals(comment, comment2);

        dao.deleteComment(comment.getCommentId());

        comment2 = dao.getComment(comment.getCommentId());

        assertNull(comment2);
    }


    @Test
    public void getAllComments() {
        Comment comment = new Comment();

        //comment.setPostId(comment.getPostId());
        comment.setCreateDate(LocalDate.of(2019, 07, 30));
        comment.setCommenterName("gregt");
        comment.setComment("Wow Bob that's Great!");
        //Comment from DAO.Add

        dao.addComment(comment);


        comment = new Comment();

       // comment.setPostId(comment.getPostId());
        comment.setCreateDate(LocalDate.of(2019, 8, 2));
        comment.setCommenterName("gregt");
        comment.setComment("Best of Luck !!");

        dao.addComment(comment);
        List<Comment> commentList = dao.getAllComments();

        assertEquals(commentList.size(), 2);

    }
}
