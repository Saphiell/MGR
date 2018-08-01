package magisterka.db;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import magisterka.entity.DataFile;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(DataFile.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try{
			
			session.beginTransaction();
			Criteria criteria = session.createCriteria(DataFile.class);
			int folder_id = 1;
			//DataFile df = session.get(DataFile.class, folder_id);
			//DataFile df = session.get
		
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally{
			session.close();
		}
		
	}

}
