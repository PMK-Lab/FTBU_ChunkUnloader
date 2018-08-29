package fr.pmk_lab.ftbu_chunkunloader;

import java.io.File;

public class NBTUtils {

	public static void getTeamList() {
		
		
		
	}
	
	public static void getPlayerList() {
		
		
		
	}
	
	public static Object getPlayerNBT(String playerName) {
		
		return getPlayerNBT(new File(playerName + ".dat")); //return nbt from player
		
	}
	
	public static Object getPlayerNBT(File f) {
		
		return null; //return nbt from player
		
	}
	
	public static int getPlayerLastSeen() {
		
		return 0;
		
	}
	
	public static String getPlayerGradeName() {
		
		return "";
		
	}
	
}
