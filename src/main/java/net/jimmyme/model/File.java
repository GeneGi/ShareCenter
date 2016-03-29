package net.jimmyme.model;

public class File {
	
	Integer fileId;
	String  fileName;
	String  fileUrl;
	User  fileOwner;
	
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public User getFileOwner() {
		return fileOwner;
	}
	public void setFileOwner(User fileOwner) {
		this.fileOwner = fileOwner;
	}
	
}
