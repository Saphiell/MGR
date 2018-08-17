package magisterka;

import magisterka.db.CreateData;
import magisterka.db.DeleteData;
import magisterka.db.GetData;

public class main {

	public static void main(String[] args) {
		
	
		CreateData cd = new CreateData();
		DeleteData dd = new DeleteData();
		GetData gd = new GetData();
		//cd.addData();
		dd.deleteData();
		//gd.getOnlyFolderName();
		//dd.deleteData();
	
		//ChooseFiles d = new ChooseFiles();
		//String path = d.FolderChooser();
		
		//System.out.println(path);
	}

}
