package net.jimmyme.model;

import java.util.Set;

/**
 * Created by jimmy on 2016/3/9.
 */
public class Tag {

    private Integer tagId;
    private String tagName;
    private Set<ArticleTag> articleTags;
    
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Set<ArticleTag> getArticleTags() {
		return articleTags;
	}
	public void setArticleTags(Set<ArticleTag> articleTags) {
		this.articleTags = articleTags;
	}
}
