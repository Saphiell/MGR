package magisterka.db;

import java.util.List;


import magisterka.entity.Folder;


public interface FolderDAO {
	public void addFolder();
	public void deleteFolder(String fname);
	public List<Folder> listFolders();
	public Folder getFolderByName(String fname);
	
}
