package fr.pmk_lab.ftbu_chunkunloader.data;

import java.io.InputStream;
import java.util.Properties;

public class InfoData {

	public static final String INFO_FILE_NAME = "info.properties";
	
	public static InfoData getInfoData() {
		
		try {
			
			InputStream inputStream = ClassLoader.getSystemResourceAsStream(INFO_FILE_NAME);
			Properties props = new Properties();
			
			props.load(inputStream);
			
			// get information in file info.properties
			String version = props.getProperty("version");
			String support = props.getProperty("support");
			String forge = props.getProperty("forge_version_use_to_dev");
			String ftb = props.getProperty("ftb_version_use_to_dev");
			
			System.out.println(version + "\n" + support + "\n" + forge + "\n" + ftb);
			
			return new InfoData(version, support, forge, ftb);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		// return default values for InfoData
		return new InfoData("default_error", "default_error" , "default_error" , "default_error");
		
	}
	
	private String version;
	private String supportLink;
	
	private String forgeVersion;
	private String FtbVersion;
	
	public InfoData(String v , String s , String fv , String ftbv) {
		
		this.version = v;
		this.supportLink = s;
		
		this.forgeVersion = fv;
		this.FtbVersion = ftbv;
		
	}
	
	public String getVersion() {
		return version;
	}

	public String getSupportLink() {
		return supportLink;
	}

	public String getForgeVersion() {
		return forgeVersion;
	}

	public String getFtbVersion() {
		return FtbVersion;
	}
	
}
