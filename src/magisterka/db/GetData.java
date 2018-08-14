package magisterka.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import magisterka.entity.DataFile;
import magisterka.entity.Folder;

public class GetData {
	
	private SessionFactory factory;
	private Session session;
	private Criteria crit;
	private Folder fd;
	private String foldername;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.POST,params = {"get"})
	public void getDataUsingFolderName(){
		
	    factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(DataFile.class)
				.addAnnotatedClass(Folder.class)
				.buildSessionFactory();

		session = factory.getCurrentSession();
		
		foldername = "Dane Pomiarowe";
		
		try{
			session.beginTransaction();
			
			crit = session.createCriteria(Folder.class);
			crit.add(Restrictions.eq("name", foldername));
			fd = (Folder)crit.list().get(0);
			//fd.getData();
			
			System.out.println("Get DataFile using name of folder they are in");
			
			session.getTransaction().commit();

			System.out.println("Done");
		}finally{
			session.close();
			factory.close();
		}
		
	}
	
	public List<Folder> getFolders(){
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(DataFile.class)
				.addAnnotatedClass(Folder.class)
				.buildSessionFactory();

		session = factory.getCurrentSession();
		List<Folder> fl = new ArrayList<>();
		
		try{
			session.beginTransaction();
			
			fl = session.createQuery("from Folder").getResultList();
			session.getTransaction().commit();

			System.out.println("Done");
		}finally{
			session.close();
			factory.close();
		}
		
		return fl;
	}

}
