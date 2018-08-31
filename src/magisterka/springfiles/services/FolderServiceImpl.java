package magisterka.springfiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import magisterka.db.FolderDAO;
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
	public void deleteFolder(String fname) {
		this.folderDAO.deleteFolder(fname);
	}

	@Override
	@Transactional
	public List<Folder> listFolders() {
		
		return this.folderDAO.listFolders();
	}

	@Override
	@Transactional
	public Folder getFolderByName(String fname) {
		// TODO Auto-generated method stub
		return this.folderDAO.getFolderByName(fname);
	}

}
