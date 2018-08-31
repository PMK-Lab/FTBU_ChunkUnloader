package fr.pmk_lab.ftbu_chunkunloader.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListIterator;

import com.kovuthehusky.nbt.NBTWriter;
import com.kovuthehusky.nbt.tags.NBT;
import com.kovuthehusky.nbt.tags.NBTByte;
import com.kovuthehusky.nbt.tags.NBTCompound;
import com.kovuthehusky.nbt.tags.NBTList;

import fr.pmk_lab.ftbu_chunkunloader.ChunkUnloaderManager;
import fr.pmk_lab.ftbu_chunkunloader.MainCU;

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

	public void unloadChunks() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		NBTCompound nbtData = fileNbt.get("Data");
		
		NBTCompound nbtFTB = new NBTCompound("ftbutilities", nbtData.get("ftbutilities"));
		
		NBTCompound nbtClaimedChunks = new NBTCompound("ClaimedChunks", nbtFTB.get("ClaimedChunks"));
		
		for (ListIterator<NBT<?>> it = nbtClaimedChunks.listIterator(); it.hasNext();) {
		
			NBTList nbtList = (NBTList) it.next();
			System.out.println(nbtList);
			
			for (ListIterator<NBT<?>> it1 = nbtList.listIterator(); it1.hasNext();) {
				
				NBTCompound nbtChunk = (NBTCompound) it1.next();
				System.out.println("\t" + nbtChunk);
				
				NBTByte loaded = nbtChunk.get("loaded");
				
				
				
				if(loaded != null) {
					System.out.println("\t\t loaded");
					loaded.setPayload((byte) 0);
					it1.set(nbtChunk);
				}
				
				
			}
			
			it.set(nbtList);
			
		}
		
		nbtFTB.add(nbtClaimedChunks);
		
		nbtData.add(nbtFTB);
		
		fileNbt.add(nbtData);
		
		PropertiesData p = MainCU.getPROPERTIES();
		
		String path = p.getWorld() + "/" + p.getFtbLibPath() + p.getTeamPath() + "/" + fileName + ".dat";
		
		System.out.println(path);
		
		File f = new File(path);
		
		NBTWriter.writeNBT(fileNbt, f);
		
	}

}