package net.jimmyme.model;

public class ArticleTag {

	Integer articleTagId;
	Article article;
	Tag     tag;
	
	public Integer getArticleTagId() {
		return articleTagId;
	}
	public void setArticleTagId(Integer articleTagId) {
		this.articleTagId = articleTagId;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
