package magisterka.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import magisterka.entity.DataFile;
import magisterka.entity.Folder;

public class GetData {
	
	public void getData(){
		
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
			
			Criteria crit = session.createCriteria(Folder.class);
			 crit.add(Restrictions.eq("name", foldername));
			fd = (Folder)crit.list().get(0);
			
			System.out.println("Get DataFile using name of folder they are in");
			
			session.getTransaction().commit();

			System.out.println("Done");
		}finally{
			session.close();
			factory.close();
		}
		
		//datalist = fd.getData();
	}

}
