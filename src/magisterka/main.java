package magisterka;

import java.util.List;

public class main {

	public static void main(String[] args) {
		
		List<String> lines;
		LoadFiles l = new LoadFiles();
		String pathtoFiles = "C:\\Users\\kusja\\workspace\\Magisterka\\src\\Dane pomiarowe";
		lines = l.load(pathtoFiles);
		int i = 1;
		for(String s :lines){
			System.out.println(i + " " + s );
			i++;
		}
	}

}
