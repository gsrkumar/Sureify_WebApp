package services;

public class URLClass {
	
	private static String url = null;

	public static  String getUrl(String environment){
		
		switch (environment.toUpperCase().trim()) {
		case "STAGING":
			url = "http://sureifylife.com/";
			break;
		case "BETA":
			url = "";
			break;
		case "ALPHA":
			url = "";
			break;
		default:
		   url = null;
		}
	
		return url;
	}
}
