package fr.pmk_lab.ftbu_chunkunloader.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesData {

	public static final String PROPERTIES_FILE_NAME = "config.properties";
	
	public static PropertiesData getPropertiesData() throws Exception {
			
		InputStream inputStream = new FileInputStream(new File(PROPERTIES_FILE_NAME));
		Properties props = new Properties();
			
		props.load(inputStream);
			
		// get information in file info.properties
		int cycle = Integer.parseInt(props.getProperty("cycle"));
		
		String wolrdName = props.getProperty("world_name");
		
		String libPath = props.getProperty("ftb_lib_path");
		String player = props.getProperty("player_path");
		String team = props.getProperty("team_path");
			
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
