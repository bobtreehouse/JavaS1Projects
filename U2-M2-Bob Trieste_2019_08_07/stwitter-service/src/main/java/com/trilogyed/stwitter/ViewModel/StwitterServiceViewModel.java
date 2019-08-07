//package com.trilogyed.stwitter.ViewModel;
//
//import java.time.LocalDate;
//import java.util.Objects;
//
//public class StwitterServiceViewModel {
//
//    private int postID;
//    private LocalDate postDate;
//    private String posterName;
//    private String post;
//    private int commentId;
//    private int postId;
//    private LocalDate createDate;
//    private String commenterName;
//    private String comment;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        StwitterServiceViewModel that = (StwitterServiceViewModel) o;
//        return getPostID() == that.getPostID() &&
//                getCommentId() == that.getCommentId() &&
//                getPostId() == that.getPostId() &&
//                getPostDate().equals(that.getPostDate()) &&
//                getPosterName().equals(that.getPosterName()) &&
//                getPost().equals(that.getPost()) &&
//                getCreateDate().equals(that.getCreateDate()) &&
//                getCommenterName().equals(that.getCommenterName()) &&
//                Objects.equals(getComment(), that.getComment());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getPostID(), getPostDate(), getPosterName(), getPost(), getCommentId(), getPostId(), getCreateDate(), getCommenterName(), getComment());
//    }
//
//    public int getPostID() {
//        return postID;
//    }
//
//    public void setPostID(int postID) {
//        this.postID = postID;
//    }
//
//    public LocalDate getPostDate() {
//        return postDate;
//    }
//
//    public void setPostDate(LocalDate postDate) {
//        this.postDate = postDate;
//    }
//
//    public String getPosterName() {
//        return posterName;
//    }
//
//    public void setPosterName(String posterName) {
//        this.posterName = posterName;
//    }
//
//    public String getPost() {
//        return post;
//    }
//
//    public void setPost(String post) {
//        this.post = post;
//    }
//
//    public int getCommentId() {
//        return commentId;
//    }
//
//    public void setCommentId(int commentId) {
//        this.commentId = commentId;
//    }
//
//    public int getPostId() {
//        return postId;
//    }
//
//    public void setPostId(int postId) {
//        this.postId = postId;
//    }
//
//    public LocalDate getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(LocalDate createDate) {
//        this.createDate = createDate;
//    }
//
//    public String getCommenterName() {
//        return commenterName;
//    }
//
//    public void setCommenterName(String commenterName) {
//        this.commenterName = commenterName;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//
//}
