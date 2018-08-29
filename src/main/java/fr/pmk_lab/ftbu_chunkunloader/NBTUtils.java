package fr.pmk_lab.ftbu_chunkunloader;

import java.io.File;
import java.io.IOException;

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
	
	
	
}
