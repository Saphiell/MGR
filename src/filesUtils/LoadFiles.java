package filesUtils;

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
	public List<String> load(File[] files){
		
		try{
			for(File f : files){
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
	
	public void Separate(List<String> list,List<String[]> listofparts,String separator){
		
		for(String s:list){
			String[] parts = s.trim().split(separator+"+");

			parts[2]+="0";
			listofparts.add(parts);
		}
		
	}
	
	public String[] Separate(String str,String separator){
				
			String[] strparts;
			strparts = str.trim().split(separator);
			return strparts;
	}
	
	
}
