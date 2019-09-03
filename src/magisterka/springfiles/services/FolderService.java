package magisterka.springfiles.services;

import java.util.List;

import magisterka.entity.DataFile;
import magisterka.entity.Folder;

public interface FolderService {
	
	public void addFolder();
	public void deleteFolder(int theId);
	public List<Folder> listFolders();
	public Folder getFolderById(int theId);
	public Folder updateFolderWithDescription(int theId, String description);
	public List<DataFile> getDataForFolder(int theId); 
}
