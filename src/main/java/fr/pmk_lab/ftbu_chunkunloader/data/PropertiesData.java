package fr.pmk_lab.ftbu_chunkunloader.data;

import java.io.InputStream;
import java.util.Properties;

import fr.pmk_lab.ftbu_chunkunloader.MainCU;

public class PropertiesData {

	public static final String PROPERTIES_FILE_NAME = "config.properties";
	
	public static PropertiesData getPropertiesData() throws Exception {
			
		InputStream inputStream = MainCU.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
		Properties props = new Properties();
			
		props.load(inputStream);
			
		// get information in file info.properties
		int cycle = Integer.parseInt(props.getProperty("cycle"));
		
		String wolrdName = props.getProperty("version");
		
		String libPath = props.getProperty("support");
		String player = props.getProperty("forge_version_use_to_dev");
		String team = props.getProperty("ftb_version_use_to_dev");
			
		//System.out.println(version + "\n" + support + "\n" + forge + "\n" + ftb);
			
		return new PropertiesData(cycle, wolrdName, libPath, player, team);
		
	}
	
	private int loadCycle;
	
	private String world;
	private String ftbLibPath;
	
	private String playerPath;
	private String teamPath;
	
	public PropertiesData(int lc , String w , String ftblp , String pp , String tp) {
		
		this.loadCycle = lc;
		
		this.world = w;
		this.ftbLibPath = ftblp;
		
		this.playerPath = pp;
		this.teamPath = tp;
		
	}

	public int getLoadCycle() {
		return loadCycle;
	}

	public String getWorld() {
		return world;
	}

	public String getFtbLibPath() {
		return ftbLibPath;
	}

	public String getPlayerPath() {
		return playerPath;
	}

	public String getTeamPath() {
		return teamPath;
	}
	
}
