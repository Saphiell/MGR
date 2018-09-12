package magisterka.db;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import magisterka.db.methods.CreateData;
import magisterka.db.methods.DeleteData;
import magisterka.db.methods.GetFromDB;
import magisterka.entity.Folder;

@Repository
@Component(value = "folderDAO")
public class FolderDAOImpl implements FolderDAO {

	
	private GetFromDB gd;
	private Folder fd;
	
	@Override
	public void addFolder() {
		CreateData CD = new CreateData();
		CD.addData();
		System.out.println("Folder saved");
	}

	@Override
	public void deleteFolder(String fname) {
		DeleteData dd = new DeleteData();
		dd.deleteFolder(fname);
		
	}

	@Override
	public List<Folder> listFolders() {
		
		return gd.GetFolders();
	}

	@Override
	public Folder getFolderByName(String fname) {	
		fd = gd.getDataUsingFolderName(fname);	
		return fd;
	}

}
