package com.trilogyed.stwitter.Util.messages;

public class CommentList {

    private String poster;
    private String comment;


    public CommentList() {


    }
    public CommentList(String poster, String comment) {
        this.poster = poster;
        this.comment = comment;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentList{" +
                "poster='" + poster + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
