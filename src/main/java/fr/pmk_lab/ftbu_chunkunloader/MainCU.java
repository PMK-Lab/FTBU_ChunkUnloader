package fr.pmk_lab.ftbu_chunkunloader;

import java.io.IOException;

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
			// g�n�ration du fichier de config
			ResourceManager.extract(PropertiesData.PROPERTIES_FILE_NAME);
			
			try {
				
				//r�cup�ration des propri�t�s dans le fichier de config
				PROPERTIES = PropertiesData.getPropertiesData();
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erreur de r�cup�ration des configurations ! EXIT");
				System.exit(0);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur d'extractions et de cr�ations du fichier de configuration ! EXIT");
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
