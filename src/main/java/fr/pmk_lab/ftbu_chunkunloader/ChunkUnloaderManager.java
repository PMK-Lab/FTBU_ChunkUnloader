package fr.pmk_lab.ftbu_chunkunloader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kovuthehusky.nbt.tags.NBTCompound;

import fr.pmk_lab.ftbu_chunkunloader.config.FileUtils;
import fr.pmk_lab.ftbu_chunkunloader.data.PlayerData;
import fr.pmk_lab.ftbu_chunkunloader.data.PropertiesData;
import fr.pmk_lab.ftbu_chunkunloader.data.TeamData;

public class ChunkUnloaderManager {

	private static long worldTime;
	
	private static HashMap<String,PlayerData> players;
	
	public static long getWorldTime(PropertiesData p) throws Exception {
		
		String pathFile = p.getWorld() + "/level.dat";
		
		File f = new File(pathFile);
		
		if(f.exists()) {
			
			return NBTUtils.getWorldDayTime(f);
			
		}else {
			
			throw new Exception("Fichier non trouvé : " + pathFile + "\n Impossible de récupérer les informations neccésaires au unload.");
			
		}
		
	}
	
	private static HashMap<String,PlayerData> getPlayerList(PropertiesData p){
		
		HashMap<String,PlayerData> playerList = new HashMap<String,PlayerData>();
		
		String path = p.getWorld() + "/" + p.getFtbLibPath() + p.getPlayerPath();
		
		List<NBTCompound> nbtList = NBTUtils.getNBTList(FileUtils.getListFiles(path));
		
		for (NBTCompound nbt : nbtList) {
			
			PlayerData player = new PlayerData(nbt);
			
			playerList.put(player.getName(),player);
			
		}
		
		return playerList;
		
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

	public static long getWorldTime() {
		return worldTime;
	}

	public static void setWorldTime(long worldDayTime) {
		ChunkUnloaderManager.worldTime = worldDayTime;
	}

	public static void runUnload() {
		// TODO Auto-generated method stub
		
		PropertiesData p = MainCU.getPROPERTIES();
		
		players = getPlayerList(p);
		
		List<TeamData> teamList =  getTeamList(p);
		
		for (TeamData teamData : teamList) {
			
			long time = ChunkUnloaderManager.getWorldTime() - teamData.getOwner().getLastTimeSeen();
			System.out.println(time);
			
			if(time > 144000) {
				
				//unload
				System.out.println("unload");
				
				teamData.unloadChunks();
				
				
			}
			
		}
		
	}

	public static HashMap<String,PlayerData> getPlayers() {
		return players;
	}
	
}
