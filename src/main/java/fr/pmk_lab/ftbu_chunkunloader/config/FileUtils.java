package fr.pmk_lab.ftbu_chunkunloader.config;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {

	public static List<File> getListFiles(String path){
		
		File f = new File(path);
		
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
		
		return files;
		
	}
	
}
