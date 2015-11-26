package dynamic.report;

public class Details {
private String fileName;
private String MCoupling;
private String MDuplicate;

public Details(String fileName, String mCoupling, String mDuplicate) {
	super();
	this.fileName = fileName;
	MCoupling = mCoupling;
	MDuplicate = mDuplicate;
}


public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getMCoupling() {
	return MCoupling;
}
public void setMCoupling(String mCoupling) {
	MCoupling = mCoupling;
}
public String getMDuplicate() {
	return MDuplicate;
}
public void setMDuplicate(String mDuplicate) {
	MDuplicate = mDuplicate;
}
}
