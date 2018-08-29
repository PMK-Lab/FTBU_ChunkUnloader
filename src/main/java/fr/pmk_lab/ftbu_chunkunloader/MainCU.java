package fr.pmk_lab.ftbu_chunkunloader;

import java.io.File;
import java.io.IOException;

import com.kovuthehusky.nbt.NBTReader;
import com.kovuthehusky.nbt.tags.NBTCompound;

import fr.pmk_lab.ftbu_chunkunloader.config.ResourceManager;
import fr.pmk_lab.ftbu_chunkunloader.data.InfoData;
import fr.pmk_lab.ftbu_chunkunloader.data.PropertiesData;

public class MainCU {
	
	private static InfoData INFO;
	private static PropertiesData PROPERTIES;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Lancement FTBU_ChunkUnloader ");
		
		INFO = InfoData.getInfoData();
		System.out.print(INFO.toString());
		
		try {
			// génération du fichier de config
			ResourceManager.extract(PropertiesData.PROPERTIES_FILE_NAME);
			
			try {
				
				//récupération des propriétés dans le fichier de config
				PROPERTIES = PropertiesData.getPropertiesData();
				
				
				
				NBTCompound nbt = getNBTFile("world/level.dat");
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erreur de récupération des configurations ! EXIT");
				System.exit(0);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur d'extractions et de créations du fichier de configuration ! EXIT");
			System.exit(0);
		}
		
	}
	
	private static NBTCompound getNBTFile(String p) {
		
		try {
			return NBTReader.read(new File(p));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	

	public static InfoData getINFO() {
		return INFO;
	}

	public static PropertiesData getPROPERTIES() {
		return PROPERTIES;
	}
	
}
