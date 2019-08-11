package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.Util.Feign.CommentServiceClient;
import com.trilogyed.stwitter.Util.Feign.PostServiceClient;
//import com.trilogyed.stwitter.ViewModel.StwitterServiceViewModel;
import com.trilogyed.stwitter.dto.Comment;
import com.trilogyed.stwitter.dto.CommentViewModel;
import com.trilogyed.stwitter.dto.Post;
import com.trilogyed.stwitter.dto.PostViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private CommentServiceClient commentServiceClient;
    private PostServiceClient postServiceClient;
    // private StwitterServiceViewModel stwitterServiceViewModel;
    private RabbitTemplate rabbitTemplate;


    public static final String COMMENT_EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.newComment";

    public ServiceLayer() {

    }

    @Autowired
    public ServiceLayer(CommentServiceClient commentServiceClient, PostServiceClient postServiceClient, RabbitTemplate rabbitTemplate) {
        this.commentServiceClient = commentServiceClient;
        this.postServiceClient = postServiceClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    public PostViewModel addPost(PostViewModel pvm) {
        PostViewModel pvm = new PostViewModel();
        Post post = new Post();
        post.setPostDate(pvm.getPostDate());
        post.setPosterName(pvm.getPosterName());
        post.setPost(pvm.getPost());

        post = postServiceClient.createPost(post);

        pvm = buildPostVM(post);

        return pvm;


    }

    @Transactional
    public PostViewModel addComment(CommentViewModel cvm, int postId) {

        Post post = postServiceClient.getPost(postId);
        if (post == null) {
            throw new IllegalArgumentException("Post cannot be retrieved by ID" + postId);

        }

        Comment comment = new Comment();
        comment.setPostId(cvm.getPostId());
        comment.setCreateDate(cvm.getCreateDate());
        comment.setComment(cvm.getComment());

        rabbitTemplate.convertAndSend(COMMENT_EXCHANGE, ROUTING_KEY, comment);

        try {
            Thread.sleep(3000L);

        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        PostViewModel pvm = buildPostVM(post);
        return pvm;
    }

    public PostViewModel getPost(int postId) {
        Post post = postServiceClient.getPost(postId);
        if (post == null) {
            throw new IllegalArgumentException("Post cannot be retrieved by ID: " + postId);

        }
        PostViewModel pvm = buildPostVM(post);
        return pvm;
    }

    public List<PostViewModel> getPostByPoster(String posterName) {
    }

    private PostViewModel buildPostVM(Post post) {
        PostViewModel pvm = new PostViewModel();

        pvm.setPostID(post.getPostID());
        pvm.setPost(post.getPost());
        pvm.setPostDate(post.getPostDate());
        pvm.setPosterName(post.getPosterName());

        List<Comment> comments = commentServiceClient.getCommentByPost(pvm.getPostID());
        List<CommentViewModel> commentVMList = new ArrayList<>();

        for (Comment c : comments) {
            commentVMList.add(buildCommentVM(c));
        }

        pvm.setComments(commentVMList);

        return pvm;
    }

    private CommentViewModel buildCommentVM(Comment comment) {
        CommentViewModel cvm = new CommentViewModel();

        cvm.setCommentId(comment.getCommentId());
        cvm.setPostId(comment.getPostId());
        cvm.setCreateDate(comment.getCreateDate());
        cvm.setComment(comment.getComment());


        return cvm;


    }
}
