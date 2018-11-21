package magisterka.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import magisterka.db.methods.CreateData;
import magisterka.db.methods.GetFromDB;
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
	public Folder getFolderByName(int theId) {	
			
		return sessionFactory.getCurrentSession().get(Folder.class, theId);
	}

}
