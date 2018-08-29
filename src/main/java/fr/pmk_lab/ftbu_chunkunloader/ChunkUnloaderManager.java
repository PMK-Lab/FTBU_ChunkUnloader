package fr.pmk_lab.ftbu_chunkunloader;

import java.io.File;

import fr.pmk_lab.ftbu_chunkunloader.data.PropertiesData;

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

	public static long getWorldDayTime() {
		return worldDayTime;
	}

	public static void setWorldDayTime(long worldDayTime) {
		ChunkUnloaderManager.worldDayTime = worldDayTime;
	}
	
}
