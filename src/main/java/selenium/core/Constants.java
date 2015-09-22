package selenium.core;

public class Constants {
	//************
	//*	TIMEOUTS *
	//************
	final static private long implicitWaitTimeout = (long) 10.0;
	final static private long pageLoadTimeout = (long) 60.0;
	final static private long scriptTimeout = (long) 20.0;
	final static private int defaultTestTimeout = 60;
	public static long getImplicitWaitTimeout(){return implicitWaitTimeout;}
	public static long getPageLoadTimeout(){return pageLoadTimeout;}
	public static long getScriptTimeout(){return scriptTimeout;}
	public static int getDefaultTestTimeout(){return defaultTestTimeout;}
	//********
	//*	URLS *
	//********
	final static private String bluesource_stage="https://bluesourcestaging.herokuapp.com/login";
	public static String getURL(String application, String environment){
		String appEnv = application.toLowerCase().trim().replace(" ", "") + "_" + environment.toLowerCase().trim().replace(" ", "");
		String url;
		switch (appEnv) {
		case "bluesource_stage":
			url = bluesource_stage;
			break;
		default:
			String message = "A URL was not located for the application ["+application+"] and environment ["+environment+"].";
			System.out.println(message);
			throw new RuntimeException(message);
		}
		return url;
	}
	//***************
	//*	CREDENTIALS *
	//***************
	final static private String bluesource_companyadmin_username="company.admin";
	final static private String bluesource_companyadmin_password="test";
	public static String[] getCredentials(String application, String role){
		String appRole = application.toLowerCase().trim().replace(" ", "") + "_" + role.toLowerCase().trim().replace(" ", "");
		String credentials[] = new String[2];
		switch (appRole) {
		case "bluesource_companyadmin":
			credentials[0] = bluesource_companyadmin_username;
			credentials[1] = bluesource_companyadmin_password;
			break;
		default:
			String message = "Credentials were not located for the application ["+application+"] and role ["+role+"].";
			System.out.println(message);
			throw new RuntimeException(message);
		}
		return credentials;
	}
}
