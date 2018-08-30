package fr.pmk_lab.ftbu_chunkunloader.data;

import java.util.List;

import com.kovuthehusky.nbt.tags.NBTCompound;

public class TeamData {

	//nbt compound
	private NBTCompound fileNbt;
	
	private String fileName;
	private String teamName;
	
	private PlayerData owner;
	private List<PlayerData> players;	
	
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
		
		//owner = NBTUtils.getNbtFromFile(f)
		
	}

	public NBTCompound getFileNbt() {
		return fileNbt;
	}

	public void setFileNbt(NBTCompound fileNbt) {
		this.fileNbt = fileNbt;
	}

}
