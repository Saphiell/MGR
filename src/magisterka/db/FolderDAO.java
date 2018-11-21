package magisterka.db;

import java.util.List;


import magisterka.entity.Folder;


public interface FolderDAO {
	public void addFolder();
	public void deleteFolder(int theId);
	public List<Folder> listFolders();
	public Folder getFolderByName(int theId);
	
}
