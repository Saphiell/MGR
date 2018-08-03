package magisterka.db;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import magisterka.entity.DataFile;
import magisterka.entity.Folder;

public class DeleteData {
	
	public boolean deleteData(){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(DataFile.class)
				.addAnnotatedClass(Folder.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		Folder fd;
		String foldername = "Dane Pomiarowe";
		try{
			session.beginTransaction();
		
			System.out.println("Deleting Folder");
			
			Criteria crit = session.createCriteria(Folder.class);
			crit.add(Restrictions.eq("name", foldername));
			fd = (Folder)crit.list().get(0);
			
			session.delete(fd);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}finally{
			session.close();
			factory.close();
		}
		
		return false;
	}

}
