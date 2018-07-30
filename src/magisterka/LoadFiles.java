package magisterka;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LoadFiles {

	
	BufferedReader br;
	File files;
	List<String> lines = new ArrayList<>();
	Scanner s;
	public List<String> load(String pathtoFiles){
		
		files = new File(pathtoFiles);
		try{
			for(File f : files.listFiles()){
				s = new Scanner(f);
				while(s.hasNextLine()){
					lines.add(s.nextLine());
				
				}
				s.close();
			}
		}
		catch(Exception ex){
			ex.getMessage();
		}
		
		return lines;
	}
	
	
}
