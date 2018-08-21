package magisterka;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import magisterka.db.CreateData;
import magisterka.db.DeleteData;
import magisterka.db.GetData;
import magisterka.entity.Folder;

public class main {

	public static void main(String[] args) {
		
	
		CreateData cd = new CreateData();
		DeleteData dd = new DeleteData();
		GetData gd = new GetData();
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
