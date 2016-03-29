package net.jimmyme.model;

import java.util.Date;
import java.util.Set;

/**
 * Created by jimmy on 2016/3/9.
 */
public class Article {
    private Integer articleId;
    private String title;
    private String text;
    private String tags;
    private Date postDate;
    private Date modifyDate;
    private User author;
    
    private Set<Comment> comments;
    private Set<ArticleTag> articleTags;
    
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<ArticleTag> getArticleTags() {
		return articleTags;
	}
	public void setArticleTags(Set<ArticleTag> articleTags) {
		this.articleTags = articleTags;
	}
}
