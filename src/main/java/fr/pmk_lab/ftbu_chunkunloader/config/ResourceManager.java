package fr.pmk_lab.ftbu_chunkunloader.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import fr.pmk_lab.ftbu_chunkunloader.MainCU;

public class ResourceManager {

	
    public static void extract(String jarFilePath) throws IOException{

    	System.out.print("Check configuration file :");
    	File f = new File(jarFilePath);
    	
    	if(!f.exists()) {
    		System.out.print("...Exist:NO ");
    		Files.copy(MainCU.class.getClassLoader().getResourceAsStream(jarFilePath), f.toPath() , StandardCopyOption.REPLACE_EXISTING);
    		System.out.print("...Copy:OK ....END");
    	}else {
    		System.out.println("...Exist:OK ....END");
    	}
    	
    }
	
}
