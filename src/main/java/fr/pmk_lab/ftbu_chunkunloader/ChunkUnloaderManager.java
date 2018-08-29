package fr.pmk_lab.ftbu_chunkunloader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fr.pmk_lab.ftbu_chunkunloader.data.PropertiesData;
import fr.pmk_lab.ftbu_chunkunloader.data.TeamData;

public class ChunkUnloaderManager {

	private static long worldDayTime;
	
	public static long getWorldDayTime(PropertiesData p) throws Exception {
		
		String pathFile = p.getWorld() + "/level.dat";
		
		File f = new File(pathFile);
		
		if(f.exists()) {
			
			return NBTUtils.getWorldDayTime(f);
			
		}else {
			
			throw new Exception("Fichier non trouvé : " + pathFile + "\n Impossible de récupérer les informations neccésaires au unload.");
			
		}
		
	}
	
	private static List<TeamData> getTeamList() {
		
		List<TeamData> teamList = new ArrayList<TeamData>();
		
		for (TeamData teamData : teamList) {
			
			
			
		}
		
		return teamList;
		
	}

	public static long getWorldDayTime() {
		return worldDayTime;
	}

	public static void setWorldDayTime(long worldDayTime) {
		ChunkUnloaderManager.worldDayTime = worldDayTime;
	}

	public static void runUnload() {
		// TODO Auto-generated method stub
		
		List<TeamData> teamList =  getTeamList();
		
	}
	
}
