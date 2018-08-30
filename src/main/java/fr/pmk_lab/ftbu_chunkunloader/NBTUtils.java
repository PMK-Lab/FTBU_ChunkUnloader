package fr.pmk_lab.ftbu_chunkunloader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kovuthehusky.nbt.NBTReader;
import com.kovuthehusky.nbt.tags.NBTCompound;
import com.kovuthehusky.nbt.tags.NBTLong;

public class NBTUtils {

	public static long getWorldDayTime(File f) throws IOException {
		
		NBTCompound nbt = NBTReader.read(f);
		
		nbt = nbt.get("Data");
		nbt = new NBTCompound("Data", nbt.getPayload());
		
		NBTLong nbtL = nbt.get("DayTime");
		
		return nbtL.getPayload();
		
	}
	
	public static List<NBTCompound> getNBTList(List<File> lf){
		
		List<NBTCompound> list = new ArrayList<NBTCompound>();
		
		for (File file : lf) {
		
			try {
				
				NBTCompound nbt = NBTReader.read(file);
				nbt.setName(file.getName());
				
				list.add(nbt);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur de récupération NBTCompound instance : " + file.getName());
				e.printStackTrace();
			}
			
		}
		
		return list;
		
	}
	
	
	
}
