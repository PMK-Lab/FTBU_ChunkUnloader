package fr.pmk_lab.ftbu_chunkunloader.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.kovuthehusky.nbt.tags.NBTCompound;

import fr.pmk_lab.ftbu_chunkunloader.ChunkUnloaderManager;

public class TeamData {

	//nbt compound
	private NBTCompound fileNbt;
	
	private String fileName;
	private String teamName;
	
	private PlayerData owner;
	
	public TeamData(NBTCompound nbt) {
		// TODO Auto-generated constructor stub
		
		this.fileNbt = nbt;
		
		this.fileName = nbt.getName();
		
		//récupération du nom
		String t = (String) nbt.get("Title").getPayload();
		
		if(t.isEmpty()) {
			
			this.teamName = this.fileName;
			
		}else {
			this.teamName = t;
		}
		
		//récupération du nom du propiétaire
		owner = ChunkUnloaderManager.getPlayers().get((String) nbt.get("Owner").getPayload());
		
	}

	public NBTCompound getFileNbt() {
		return fileNbt;
	}

	public void setFileNbt(NBTCompound fileNbt) {
		this.fileNbt = fileNbt;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public PlayerData getOwner() {
		return owner;
	}

	public void setOwner(PlayerData owner) {
		this.owner = owner;
	}

}
