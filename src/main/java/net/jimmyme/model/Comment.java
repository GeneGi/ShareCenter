package net.jimmyme.model;

import java.util.Date;

/**
 * Created by jimmy on 2016/3/9.
 */
public class Comment {
    private Integer commentId;
    private Date commentDate;
    private String content;
    private Integer childCommentId;
    private User commentator;
    private Article article;
    
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getChildCommentId() {
		return childCommentId;
	}
	public void setChildCommentId(Integer childCommentId) {
		this.childCommentId = childCommentId;
	}
	public User getCommentator() {
		return commentator;
	}
	public void setCommentator(User commentator) {
		this.commentator = commentator;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
}
