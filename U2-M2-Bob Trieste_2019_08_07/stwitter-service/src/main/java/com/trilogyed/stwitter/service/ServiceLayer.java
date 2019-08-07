package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.Util.Feign.CommentServiceClient;
import com.trilogyed.stwitter.Util.Feign.PostServiceClient;
//import com.trilogyed.stwitter.ViewModel.StwitterServiceViewModel;
import com.trilogyed.stwitter.dto.Comment;
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
    public PostViewModel addPost (PostViewModel pvm) {

        Post post = new Post();
        post.setPostDate(pvm.getPostDate());
        post.setPosterName(pvm.getPosterName());
        post.setPost(pvm.getPost());

        post = postServiceClient.createPost(post);

        pvm = buildPostVM(post);

        return pvm;


    }





    {

    //HELPER METHODS
//    private StwitterServiceViewModel buildCommentViewModel (Comment Comment) {
//        StwitterServiceViewModel CommentViewModel = new CommentViewModel();
//        CommentViewModel.setCommentId(Comment.getCommentId());
//        CommentViewModel.setBookId(Comment.getBookId());
//        CommentViewModel.setComment(Comment.getComment());
//        return CommentViewModel;
//    }

}


}
