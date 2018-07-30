package magisterka;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		
		List<String> lines;
		LoadFiles l = new LoadFiles();
		String pathtoFiles = "C:\\Users\\kusja\\workspace\\Magisterka\\src\\Dane pomiarowe";
		lines = l.load(pathtoFiles);
		
		System.out.println(lines);
		
		
		List<String[]> value = new ArrayList<>();
		l.Separate(lines,value);
		
		for(String[] s:value){
			s[2]+="0";
				
			System.out.println(s[2]);
		}
		
		
	}

}
