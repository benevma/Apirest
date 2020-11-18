package my.rest.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiRestPropertiesUtil {
	
	private static ApiRestPropertiesUtil instance = null;
	
	private ApiRestPropertiesUtil(){}
	
	private String bearer;
	private String giturl;
	private String gitdirupload;
	private String gituser;
	private String gitpassword;
	private boolean updateGit;
	private String analyzeurl;
	private String categorizeurl;
	
	public static ApiRestPropertiesUtil getInstance(){
		
		if(instance==null){

			try {
				File configDir = new File(System.getProperty("catalina.base"), "conf");
				File configFile = new File(configDir, "apirest.properties");
				InputStream stream = new FileInputStream(configFile);
				Properties props = new Properties();
				props.load(stream);
				System.out.println(props.getProperty("apiresturl"));
				instance.setBearer(props.getProperty("bearer"));
				instance.setGiturl(props.getProperty("giturl"));
				instance.setGitdirupload(props.getProperty("gitdirupload"));
				instance.setGituser(props.getProperty("gituser"));
				instance.setGitpassword(props.getProperty("gitpassword"));
				instance.setUpdateGit(new Boolean(props.getProperty("updateGit")));;
				instance.setAnalyzeurl(props.getProperty("analyzeurl"));
				instance.setCategorizeurl(props.getProperty("categorizeurl"));
				
			} catch (FileNotFoundException e) {
				System.out.println("PropertiesUtil FileNotFoundException");
			} catch (IOException e) {
				System.out.println("PropertiesUtil IOException");
			}
			
		}
		return instance;
		
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	public String getGiturl() {
		return giturl;
	}

	public void setGiturl(String giturl) {
		this.giturl = giturl;
	}

	public String getGitdirupload() {
		return gitdirupload;
	}

	public void setGitdirupload(String gitdirupload) {
		this.gitdirupload = gitdirupload;
	}

	public String getGituser() {
		return gituser;
	}

	public void setGituser(String gituser) {
		this.gituser = gituser;
	}

	public String getGitpassword() {
		return gitpassword;
	}

	public void setGitpassword(String gitpassword) {
		this.gitpassword = gitpassword;
	}

	public boolean isUpdateGit() {
		return updateGit;
	}

	public void setUpdateGit(boolean updateGit) {
		this.updateGit = updateGit;
	}

	public String getAnalyzeurl() {
		return analyzeurl;
	}

	public void setAnalyzeurl(String analyzeurl) {
		this.analyzeurl = analyzeurl;
	}

	public String getCategorizeurl() {
		return categorizeurl;
	}

	public void setCategorizeurl(String categorizeurl) {
		this.categorizeurl = categorizeurl;
	}

	
}
