package fr.pmk_lab.ftbu_chunkunloader;

import fr.pmk_lab.ftbu_chunkunloader.data.InfoData;
import fr.pmk_lab.ftbu_chunkunloader.data.PropertiesData;

public class MainCU {
	
	private static InfoData INFO;
	private static PropertiesData PROPERTIES;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Lancement FTBU_ChunkUnloader ");
		
		INFO = InfoData.getInfoData();
		
		try {
			
			PROPERTIES = PropertiesData.getPropertiesData();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur de récupération des configurations ! EXIT");
			System.exit(0);
		}
		
	}

	public static InfoData getINFO() {
		return INFO;
	}

	public static PropertiesData getPROPERTIES() {
		return PROPERTIES;
	}
	
}
