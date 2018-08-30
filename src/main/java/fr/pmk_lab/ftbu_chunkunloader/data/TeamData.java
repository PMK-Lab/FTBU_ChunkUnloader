package fr.pmk_lab.ftbu_chunkunloader.data;

import com.kovuthehusky.nbt.tags.NBTCompound;

public class TeamData {

	//nbt compound
	private NBTCompound fileNbt;
	
	public TeamData(NBTCompound nbt) {
		// TODO Auto-generated constructor stub
		
		this.fileNbt = nbt;
		
		
		
	}

	public NBTCompound getFileNbt() {
		return fileNbt;
	}

	public void setFileNbt(NBTCompound fileNbt) {
		this.fileNbt = fileNbt;
	}

}
