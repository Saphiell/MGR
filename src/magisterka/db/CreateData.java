package magisterka.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import magisterka.entity.DataFile;
import magisterka.entity.Folder;

public class CreateData {
	
	public boolean addData(){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(DataFile.class)
				.addAnnotatedClass(Folder.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			session.getTransaction().commit();
			
		}finally{
			session.close();
			factory.close();
		}
		
		return false;
	}

}
