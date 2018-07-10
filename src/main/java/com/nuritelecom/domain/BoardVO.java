package com.nuritelecom.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardVO {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private String updatedate;
	private Integer viewcnt;
	private String files;

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public Integer getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", updatedate=" + updatedate + ", viewcnt=" + viewcnt + ", files=" + files + ", getBno()="
				+ getBno() + ", getTitle()=" + getTitle() + ", getContent()=" + getContent() + ", getWriter()="
				+ getWriter() + ", getRegdate()=" + getRegdate() + ", getUpdatedate()=" + getUpdatedate()
				+ ", getViewcnt()=" + getViewcnt() + ", getFiles()=" + getFiles() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

}
