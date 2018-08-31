package magisterka.springfiles.services;

import java.util.List;

import magisterka.entity.Folder;

public interface FolderService {
	
	public void addFolder();
	public void deleteFolder(String fname);
	public List<Folder> listFolders();
	public Folder getFolderByName(String fname);
}
