package fr.pmk_lab.ftbu_chunkunloader.data;

import com.kovuthehusky.nbt.tags.NBTCompound;

public class PlayerData {

	//nbt compound
	private NBTCompound fileNbt;
	
	private String name;
	private String teamID;
	private String UUID;
	
	private long lastTimeSeen;
	
	public PlayerData(NBTCompound nbt) {
		// TODO Auto-generated constructor stub
		
		this.fileNbt = nbt;
		
		this.name = (String) nbt.get("Name").getPayload();
		
		this.teamID = (String) nbt.get("TeamID").getPayload();
		
		this.UUID = (String) nbt.get("UUID").getPayload();
		
		this.lastTimeSeen = (long) nbt.get("LastTimeSeen").getPayload();
		
		//System.out.println(name + "  " + teamID + "  " + UUID + "  " + lastTimeSeen + "  " + hasTeam());
		
	}
	
	public boolean hasTeam() {
		
		if(teamID.isEmpty())
			return false;
		
		return true;
		
	}
	
	public String getName() {
		return name;
	}

	public NBTCompound getFileNbt() {
		return fileNbt;
	}

	public String getTeamID() {
		return teamID;
	}

	public String getUUID() {
		return UUID;
	}

	public long getLastTimeSeen() {
		return lastTimeSeen;
	}
	
}
