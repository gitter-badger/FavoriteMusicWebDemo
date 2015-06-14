package mplanweb.music.web.uploadtest;

public class Uploadfile {
	private String pimgName;
	private String p320Name;
	private String p192Name;
	private String fimgName;
	private String f320Name;
	private String f192Name;
	private String uploadFimgName;
	private String uploadF320Name;
	private String uploadF192Name;
	private long imgsize;
	private long m320size;
	private long m192size;
	private String imgcontentType;
	private String m320contentType;
	private String m192contentType;
	private String downlinkimg;
	private String downlink320k;
	private String downlink192k;
	
	public Uploadfile(String pimgName, String p320Name, String p192Name,
			String fimgName, String f320Name, String f192Name,
			String uploadFimgName, String uploadF320Name,
			String uploadF192Name, long imgsize, long m320size, long m192size,
			String imgcontentType, String m320contentType,
			String m192contentType, String downlinkimg, String downlink320k,
			String downlink192k) {
		// TODO Auto-generated constructor stub
		super();
		this.pimgName = pimgName;
		this.p320Name = p320Name;
		this.p192Name = p192Name;
		this.fimgName = fimgName;
		this.f320Name = f320Name;
		this.f192Name = f192Name;
		this.uploadFimgName = uploadFimgName;
		this.uploadF320Name = uploadF320Name;
		this.uploadF192Name = uploadF192Name;
		this.imgsize = imgsize;
		this.m320size = m320size;
		this.m192size = m192size;
		this.imgcontentType = imgcontentType;
		this.m320contentType = m320contentType;
		this.m192contentType = m192contentType;
		this.downlinkimg = downlinkimg;
		this.downlink320k = downlink320k;
		this.downlink192k = downlink192k;

	}
	public String getPimgName() {
		return pimgName;
	}
	public void setPimgName(String pimgName) {
		this.pimgName = pimgName;
	}
	public String getP320Name() {
		return p320Name;
	}
	public void setP320Name(String p320Name) {
		this.p320Name = p320Name;
	}
	public String getP192Name() {
		return p192Name;
	}
	public void setP192Name(String p192Name) {
		this.p192Name = p192Name;
	}
	public String getFimgName() {
		return fimgName;
	}
	public void setFimgName(String fimgName) {
		this.fimgName = fimgName;
	}
	public String getF320Name() {
		return f320Name;
	}
	public void setF320Name(String f320Name) {
		this.f320Name = f320Name;
	}
	public String getF192Name() {
		return f192Name;
	}
	public void setF192Name(String f192Name) {
		this.f192Name = f192Name;
	}
	public String getUploadFimgName() {
		return uploadFimgName;
	}
	public void setUploadFimgName(String uploadFimgName) {
		this.uploadFimgName = uploadFimgName;
	}
	public String getUploadF320Name() {
		return uploadF320Name;
	}
	public void setUploadF320Name(String uploadF320Name) {
		this.uploadF320Name = uploadF320Name;
	}
	public String getUploadF192Name() {
		return uploadF192Name;
	}
	public void setUploadF192Name(String uploadF192Name) {
		this.uploadF192Name = uploadF192Name;
	}
	public long getImgsize() {
		return imgsize;
	}
	public void setImgsize(long imgsize) {
		this.imgsize = imgsize;
	}
	public long getM320size() {
		return m320size;
	}
	public void setM320size(long m320size) {
		this.m320size = m320size;
	}
	public long getM192size() {
		return m192size;
	}
	public void setM192size(long m192size) {
		this.m192size = m192size;
	}
	public String getImgcontentType() {
		return imgcontentType;
	}
	public void setImgcontentType(String imgcontentType) {
		this.imgcontentType = imgcontentType;
	}
	public String getM320contentType() {
		return m320contentType;
	}
	public void setM320contentType(String m320contentType) {
		this.m320contentType = m320contentType;
	}
	public String getM192contentType() {
		return m192contentType;
	}
	public void setM192contentType(String m192contentType) {
		this.m192contentType = m192contentType;
	}
	public String getDownlinkimg() {
		return downlinkimg;
	}
	public void setDownlinkimg(String downlinkimg) {
		this.downlinkimg = downlinkimg;
	}
	public String getDownlink320k() {
		return downlink320k;
	}
	public void setDownlink320k(String downlink320k) {
		this.downlink320k = downlink320k;
	}
	public String getDownlink192k() {
		return downlink192k;
	}
	public void setDownlink192k(String downlink192k) {
		this.downlink192k = downlink192k;
	}
	
	@Override
	public String toString() {
		return "Uploadfile [name1=" + pimgName + ", name2=" + p320Name
				+ ", name3=" + p192Name +
				", fileName1=" + fimgName + ", fileName2=" + f320Name
				+ ", fileName3=" + f192Name +
				", uploadedFileName1=" + uploadFimgName + ", uploadedFileName2="
				+ uploadF320Name + ", uploadedFileName3=" + uploadF192Name +
				", fileSize1=" + imgsize + ", fileSize2=" + m320size
				+ ", fileSize3=" + m192size +
				", contentType1=" + imgcontentType + ", contentType2="
				+ m320contentType + ", contentType3=" + m192contentType +
				", downlink1=" + downlinkimg + ", downlink2=" + downlink320k
				+ ", downlink3=" + downlink192k +
				"]";
	}
	
}
