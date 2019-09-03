package magisterka.springfiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import magisterka.db.FolderDAO;
import magisterka.entity.DataFile;
import magisterka.entity.Folder;

@Service
@Component("folderService")
public class FolderServiceImpl implements FolderService {
	
	@Value("#{folderDAO}")
	private FolderDAO folderDAO;
	
	
	public void setFolderDAO(FolderDAO folderDAO){
		this.folderDAO = folderDAO;
	}
	
	@Transactional
	@Override
	public void addFolder() {
		this.folderDAO.addFolder();
	}

	@Override
	@Transactional
	public void deleteFolder(int theId) {
		this.folderDAO.deleteFolder(theId);
	}

	@Override
	@Transactional
	public List<Folder> listFolders() {
		
		return this.folderDAO.listFolders();
	}

	@Override
	@Transactional
	public Folder getFolderById(int theId) {
		
		return this.folderDAO.getFolderById(theId);
	}

	@Override
	@Transactional
	public Folder updateFolderWithDescription(int theId, String description) {
		
		return this.folderDAO.updateFolderWithDescription(theId, description);
	}

	@Override
	@Transactional
	public List<DataFile> getDataForFolder(int theId) {
		
		return this.folderDAO.getDataForFolder(theId);
	}

}
