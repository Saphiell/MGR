package magisterka;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import magisterka.db.methods.CreateData;
import magisterka.db.methods.DeleteData;
import magisterka.db.methods.GetFromDB;
import magisterka.entity.Folder;

public class main {

	public static void main(String[] args) {
		
	
		CreateData cd = new CreateData();
		DeleteData dd = new DeleteData();
		GetFromDB gd = new GetFromDB();
		cd.addData();
		//dd.deleteData();
		//gd.getOnlyFolderName();
		//dd.deleteData();
		List<String> foldernames = new ArrayList<>();
		//List<Folder> fl = gd.GetFolders();
		
		
		foldernames.forEach(i-> System.out.println(i));
		//ChooseFiles d = new ChooseFiles();
		//String path = d.FolderChooser();
		
		//System.out.println(path);
	}

}
