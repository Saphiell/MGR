package magisterka.db;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import magisterka.entity.DataFile;
import magisterka.entity.Folder;

public class DeleteData {
	
	private SessionFactory factory;
	private Session session;
	private Criteria crit;
	
	private String foldername;
	private Folder fd;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.POST,params = {"delete"})
	public void deleteData(){
		
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(DataFile.class)
				.addAnnotatedClass(Folder.class)
				.buildSessionFactory();

		session = factory.getCurrentSession();
		foldername= "Dane Pomiarowe";
		
		try{
			session.beginTransaction();
		
			System.out.println("Deleting Folder");
			
			crit = session.createCriteria(Folder.class);
			crit.add(Restrictions.eq("name", foldername));
			fd = (Folder)crit.list().get(0);
			
			session.delete(fd);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}finally{
			session.close();
			factory.close();
		}

	}

}
