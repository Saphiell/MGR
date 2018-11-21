package magisterka.springfiles.services;

import java.util.List;

import magisterka.entity.Folder;

public interface FolderService {
	
	public void addFolder();
	public void deleteFolder(int theId);
	public List<Folder> listFolders();
	public Folder getFolderByName(int theId);
}
