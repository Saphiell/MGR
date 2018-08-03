package magisterka.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import magisterka.LoadFiles;
import magisterka.entity.DataFile;
import magisterka.entity.Folder;

public class CreateData {
	
	public boolean addData(){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(DataFile.class)
				.addAnnotatedClass(Folder.class)
				.buildSessionFactory();
		
		String pathtoFiles = "C:\\Users\\kusja\\workspace\\Magisterka\\src\\Dane pomiarowe";
		
		
		Session session = factory.getCurrentSession();
		List<String> list = new ArrayList<>();
		List<String[]> listofparts = new ArrayList<>();
		List<DataFile> datafilelist = new ArrayList<>();
		
		LoadFiles lf = new LoadFiles();
		list = lf.load(pathtoFiles);
		lf.Separate(list, listofparts);
		try{
			Folder folder; //= new Folder("Dane Pomiarowe");
			DataFile df;
			
			
			session.beginTransaction();
			System.out.println("Deleting folder");
			
			folder = new Folder("Dane Pomiarowe");
			System.out.println("Adding datafiles to folder list");
			for(String[] s: listofparts){
				df = new DataFile(s[0],s[1],s[2]);
				folder.addDataFile(df);
				session.save(df);
			}
			session.save(folder);
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally{
			session.close();
			factory.close();
		}
		
		return false;
	}

}
