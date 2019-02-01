package functions;

public class FileNameHolder {
	String fileName;
	//A simple data structure for editable table text fields
	public FileNameHolder(String fname) {
		setFileName(fname);
	}
	public FileNameHolder() {
		setFileName("Untilted");
	}
	
	public void setFileName(String fnm) {
		if(!(fnm.equals(null)||!(fnm.length()>=1))) {
			fileName=fnm;
		}else {
			fileName="Untilted";
		}
	}
	
	public void setFileName(Object f) {
		if(!(f instanceof String)) {
			setFileName(((String)f).toString());
		}
		setFileName(f.toString());
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String  toString() {
		return String.valueOf(fileName);
	}
}
