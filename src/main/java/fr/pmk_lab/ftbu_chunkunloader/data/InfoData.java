package fr.pmk_lab.ftbu_chunkunloader.data;

public class InfoData {

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
