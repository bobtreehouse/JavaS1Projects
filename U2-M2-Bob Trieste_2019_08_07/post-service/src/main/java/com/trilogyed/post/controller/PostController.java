package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class PostController {

    @Autowired
    PostDao dao;

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post) {
        return post;
    }

//    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
//    public Post getPost(@PathVariable int id) {
//        return null;
//    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public void deletePost(@PathVariable int id) {

    }
}
