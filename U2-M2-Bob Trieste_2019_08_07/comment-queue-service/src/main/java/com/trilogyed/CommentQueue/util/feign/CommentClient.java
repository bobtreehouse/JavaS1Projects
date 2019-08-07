package com.trilogyed.CommentQueue.util.feign;

import com.trilogyed.CommentQueue.util.message.Comment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentClient {

}
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public void addComment(@RequestMapping  Comment comment);

