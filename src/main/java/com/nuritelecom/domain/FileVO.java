package com.nuritelecom.domain;

import java.util.Date;

public class FileVO {
	private Integer fno, bno;
	private String originalFileName,storedFileName, creaId,delGb;
	private float fileSize;
	private Date creaDtm;
	public Integer getFno() {
		return fno;
	}
	public void setFno(Integer fno) {
		this.fno = fno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public String getCreaId() {
		return creaId;
	}
	public void setCreaId(String creaId) {
		this.creaId = creaId;
	}
	public String getDelGb() {
		return delGb;
	}
	public void setDelGb(String delGb) {
		this.delGb = delGb;
	}
	public float getFileSize() {
		return fileSize;
	}
	public void setFileSize(float fileSize) {
		this.fileSize = fileSize;
	}
	public Date getCreaDtm() {
		return creaDtm;
	}
	public void setCreaDtm(Date creaDtm) {
		this.creaDtm = creaDtm;
	}
	@Override
	public String toString() {
		return "FileVO [fno=" + fno + ", bno=" + bno + ", originalFileName=" + originalFileName + ", storedFileName="
				+ storedFileName + ", creaId=" + creaId + ", delGb=" + delGb + ", fileSize=" + fileSize + ", creaDtm="
				+ creaDtm + "]";
	}
	
	

	
	

}
