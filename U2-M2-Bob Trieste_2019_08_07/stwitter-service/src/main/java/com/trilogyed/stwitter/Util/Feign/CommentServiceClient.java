package com.trilogyed.stwitter.Util.Feign;
import com.trilogyed.stwitter.dto.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @RequestMapping (value = "/comments/book/{id}", method = RequestMethod.GET)
    public Comment getComment( @PathVariable("id") int CommentId);

    @RequestMapping (value = "/comments/{id}", method = RequestMethod.PUT)
    public Comment updateComment(@PathVariable("id") int postId, @RequestBody Comment comment);

    @RequestMapping (value = "/comments/{id}", method = RequestMethod.DELETE)
    public Comment deleteComment( @PathVariable("id") int CommentId);

    @RequestMapping (value = "/comments/", method = RequestMethod.GET)
    public Comment getAllComments();

    @RequestMapping (value = "/comments/posts/{postId}", method = RequestMethod.GET)
    public List<Comment> getCommentByPost( @PathVariable("postId") int postId);

}