package fr.pmk_lab.ftbu_chunkunloader.data;

import com.kovuthehusky.nbt.tags.NBT;
import com.kovuthehusky.nbt.tags.NBTByte;
import com.kovuthehusky.nbt.tags.NBTCompound;
import com.kovuthehusky.nbt.tags.NBTList;

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

	public void unloadChunks() {
		// TODO Auto-generated method stub
		
		NBTCompound nbt = fileNbt.get("Data");
		nbt = new NBTCompound("ftbutilities", nbt.get("ftbutilities"));
		nbt = new NBTCompound("ClaimedChunks", nbt.get("ClaimedChunks"));
		System.out.println(nbt);
		
		for (NBT<?> nbt2 : nbt) {
			
			NBTList nbt3 = (NBTList) nbt2;
			
			System.out.println(nbt3);
			
			for ( NBT<?> nbt4 : nbt3) {
				
				NBTCompound nbt5 = (NBTCompound) nbt4;
				System.out.println(nbt5);
				
				NBTByte nbt6 = nbt5.get("loaded");
				
				if(nbt6 != null) {
					
					System.out.println(nbt6);
					nbt6.setPayload((byte) 0);
					nbt5.add(nbt6);
					
				}
				
				nbt3.add(nbt5);
				
			}
			
			
			
		}
		
		//System.out.println(nbt);
		
		
		
		//nbt = new NBTCompound("", nbt.getPayload());
		//System.out.println(nbt);
		
		//new NBTCompound("", new NBTCompound("Data", fileNbt.get("Data")).get(""));		
	}

}
