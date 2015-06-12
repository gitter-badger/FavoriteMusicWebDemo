

package mplanweb.music.web.json;

public class UploadFile {
	
	
	public static final String Img_dir = "e:/upload/img/";
	public static final String Music192k_dir = "e:/upload/music192k/";
	public static final String Music320k_dir = "e:/upload/music320k/";
	private String id;
	private String contentType;
	private int contentLength;
	private String fileName;
	
	public UploadFile(String id, String contentType, int contentLength, String fileName){
		this.id = id;
		this.contentType = contentType;
		this.contentLength = contentLength;
		this.fileName = fileName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static String getImgDir() {
		return Img_dir;
	}

	public static String getMusic192kDir() {
		return Music192k_dir;
	}

	public static String getMusic320kDir() {
		return Music320k_dir;
	}

	
	
	
}
