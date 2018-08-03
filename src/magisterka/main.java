package magisterka;

import java.util.ArrayList;
import java.util.List;

import magisterka.db.CreateData;
import magisterka.db.DeleteData;
import magisterka.db.GetData;
import webtools.blabwgwda;

public class main {

	public static void main(String[] args) {
		
		List<String> lines;
		LoadFiles l = new LoadFiles();
		
		CreateData cd = new CreateData();
		DeleteData dd = new DeleteData();
		GetData gd = new GetData();
		//cd.addData();
		//gd.getData();
		//dd.deleteData();
	
		blabwgwda d = new blabwgwda();
		String path = d.FolderChooser();
		System.out.println(path);
	}

}
