package com.trilogyed.CommentQueue;

import com.trilogyed.CommentQueue.util.feign.CommentClient;
import com.trilogyed.CommentQueue.util.message.Comment;
import com.trilogyed.CommentQueue.util.message.Msg;
import com.trilogyed.CommentQueue.util.message.Note;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    private CommentClient commentClient;

    public MessageListener(CommentClient commentClient) {
        this.commentClient = commentClient;
    }


    @RabbitListener(queues = CommentQueueApplication.QUEUE_NAME)
    public void receiveMessages(Comment message) {
        System.out.println(message.toString());
        commentClient.addComment(message);
    }
}
