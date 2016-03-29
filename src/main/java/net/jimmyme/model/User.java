package net.jimmyme.model;

import java.util.Set;

/**
 * Created by jimmy on 2016/3/9.
 */
public class User {

    private Integer userId;
    private String userName;
    private Integer userType;
    private String password;
    private String mail;
    private String profile;
    private String photoUrl;

    private Set<Article> articles;
    private Set<Comment> comments;
    private Set<File>    files;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<File> getFiles() {
		return files;
	}
	public void setFiles(Set<File> files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", password=" + password
				+ ", mail=" + mail + ", profile=" + profile + ", photoUrl=" + photoUrl + ", articles=" + articles
				+ ", comments=" + comments + ", files=" + files + "]";
	}

    
}
