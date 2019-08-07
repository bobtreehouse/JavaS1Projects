package com.trilogyed.stwitter.Util.Feign;

import com.trilogyed.stwitter.dto.Comment;
import com.trilogyed.stwitter.dto.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "post-service")
public interface PostServiceClient {

    @RequestMapping (value = "/posts", method = RequestMethod.PUT)
    public Post createPost(@RequestBody @Valid Post post);

    @RequestMapping (value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost( @PathVariable("id") int postId);

    @RequestMapping (value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    public List getPostByPoster(@PathVariable("poster_name") String posterName);

    @RequestMapping (value = "/posts/{id}", method = RequestMethod.PUT)
    public Post updatePost( @PathVariable("id") int PostId, @RequestBody Post post);

    @RequestMapping (value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("id") int postId);

    @RequestMapping (value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts();

}