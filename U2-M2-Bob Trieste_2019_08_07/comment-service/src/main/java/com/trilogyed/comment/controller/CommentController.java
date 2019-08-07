package com.trilogyed.comment.controller;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class CommentController {

    @Autowired
    CommentDao dao;

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment comment) {
        return comment;
    }


    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public void deleteComment(@PathVariable int id) {

    }

}
