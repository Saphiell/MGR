package magisterka.db;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import magisterka.db.methods.CreateData;
import magisterka.db.methods.GetFromDB;
import magisterka.entity.DataFile;
import magisterka.entity.Folder;

@Repository
public class FolderDAOImpl implements FolderDAO {

	
	@Autowired
	public SessionFactory sessionFactory;
	
	protected Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }
	
	@Override
	public void addFolder() {
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		CreateData CD = new CreateData();
		CD.addData();
		System.out.println("Folder saved");
	}

	@Override
	public void deleteFolder(int theId) {
		Folder f = sessionFactory.getCurrentSession().get(Folder.class, theId);
		sessionFactory.getCurrentSession().delete(f);
		
	}

	@Override
	public List<Folder> listFolders() {
		
		return sessionFactory.getCurrentSession().createQuery("from Folder order by folder_name", Folder.class).getResultList();
	}

	@Override
	public Folder getFolderById(int theId) {	
			
		return sessionFactory.getCurrentSession().get(Folder.class, theId);
	}

	@Override
	public Folder updateFolderWithDescription(int theId, String description) {
		Folder f = sessionFactory.getCurrentSession().get(Folder.class, theId);
		
		f.setDescription(description);
		
		
		return (Folder) sessionFactory.getCurrentSession().save(f);
	}

	@Override
	public List<DataFile> getDataForFolder(int theId) {
		
		//Folder f = getFolderById(theId);
		//int id = f.getId();
		Query<DataFile> query = sessionFactory.getCurrentSession().createQuery("from DataFile where folder.id=:folder_id",DataFile.class);
		query.setParameter("folder_id", theId);
		//query.list();
		
		List<DataFile> dataPoints = query.list();
		System.out.println("dataPoints");
		return dataPoints;
	}

	
	
	

}
