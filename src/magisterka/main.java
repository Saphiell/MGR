package magisterka;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import magisterka.db.FolderDAOImpl;
import magisterka.db.methods.CreateData;
import magisterka.db.methods.DeleteData;
import magisterka.db.methods.GetFromDB;
import magisterka.entity.Folder;

public class main {

	public static void main(String[] args) {
		
	
		FolderDAOImpl fd = new FolderDAOImpl();
		//dd.deleteData();
		//gd.getOnlyFolderName();
		//dd.deleteData();
		GetFromDB dg = new GetFromDB();
		dg.GetFolders().stream().forEach(i-> System.out.println(i));
		
		//ChooseFiles d = new ChooseFiles();
		//String path = d.FolderChooser();
		
		//System.out.println(path);
	}

}
