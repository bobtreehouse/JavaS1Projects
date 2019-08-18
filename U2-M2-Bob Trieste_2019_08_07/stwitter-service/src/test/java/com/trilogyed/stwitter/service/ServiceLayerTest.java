package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.dto.Comment;
import com.trilogyed.stwitter.dto.Post;
import com.trilogyed.stwitter.ViewModel.CommentViewModel;
import com.trilogyed.stwitter.ViewModel.PostViewModel;
import com.trilogyed.stwitter.Util.Feign.CommentServiceClient;
import com.trilogyed.stwitter.Util.Feign.PostServiceClient;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Local;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

import static org.junit.Assert.*;

@SpringBootTest
public class ServiceLayerTest {

    public static final String COMMENT_EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.newComment";

     CommentServiceClient commentServiceClient;
     PostServiceClient postServiceClient;
     RabbitTemplate rabbitTemplate;
     ServiceLayer service;


    @Before
    public void setUp() throws Exception {


        setUpCommentServiceMock();
        setUpPostServiceMock();
        setUpRabbitTemplate();

        service = new ServiceLayer(commentServiceClient, postServiceClient, rabbitTemplate);


    }

    private void setUpCommentServiceMock() {
    }
    private void setUpPostServiceMock() {
    }
    private void setUpRabbitTemplate() {
    }

    @Test
    public void addGetPost() {

        PostViewModel pvm = new PostViewModel();

        pvm.setPost("I am busy building the Hyperloop");
        pvm.setPostDate(LocalDate.of(2019, 07, 30));
        pvm.setPosterName("bobt");

        pvm = service.addPost(pvm);

        Post post = new Post();
        post.setPostID(pvm.getPostID());
        post.setPostDate(pvm.getPostDate());
        post.setPosterName(pvm.getPosterName());
        post.setPost(pvm.getPost());

        PostViewModel pvmTest = service.getPost(post.getPostID());

        Post postTest = new Post();

        postTest.setPostID(pvm.getPostID());
        postTest.setPostDate(pvm.getPostDate());
        postTest.setPosterName(pvm.getPosterName());
        postTest.setPost(pvm.getPost());


    }


    @Test
    public void addComment() {
    }

    @Test
    public void getPostByPoster() {
    }





}
