package fr.pmk_lab.ftbu_chunkunloader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.kovuthehusky.nbt.tags.NBTCompound;

import fr.pmk_lab.ftbu_chunkunloader.config.FileUtils;
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
			
			throw new Exception("Fichier non trouv� : " + pathFile + "\n Impossible de r�cup�rer les informations necc�saires au unload.");
			
		}
		
	}
	
	private static List<TeamData> getTeamList(PropertiesData p) {
		
		List<TeamData> teamList = new ArrayList<TeamData>();
		
		String path = p.getWorld() + "/" + p.getFtbLibPath() + p.getTeamPath();
		
		List<NBTCompound> nbtList = NBTUtils.getNBTList(FileUtils.getListFiles(path));
		
		for (NBTCompound nbt : nbtList) {
			
			TeamData team = new TeamData(nbt);
			
			teamList.add(team);
			
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
		
		List<TeamData> teamList =  getTeamList(MainCU.getPROPERTIES());
		
	}
	
}
