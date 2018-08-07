package magisterka.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import filesUtils.ChooseFiles;
import filesUtils.LoadFiles;
import magisterka.entity.DataFile;
import magisterka.entity.Folder;

public class CreateData {
	
	private ChooseFiles cf;
	private Session session;
	private LoadFiles lf;
	private GetData gd;
	
	private List<String> datafromfiles,filesname;
	private List<String[]> partsfromfiles;

	
	private String pathtoFiles,foldername;
	private String[] partsoffolders;
	
	
	public void addData(){
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(DataFile.class)
				.addAnnotatedClass(Folder.class)
				.buildSessionFactory();
		
		cf = new ChooseFiles();
		lf = new LoadFiles();
		 
		session = factory.getCurrentSession();
		datafromfiles = new ArrayList<>();
		partsfromfiles = new ArrayList<>();
		

		datafromfiles = cf.FolderChooser();
		
		/*
		 * SprawdŸ czy w bazie nie ma plików o tej samej nazwie, jeœli tak to nie dodawaj, jeœli nie ma czêœci to dodaj tylko te co ich nie ma
		 * Jebaæ foldery, ale przydadz¹ siê 
		 */
		
		try{
			
			if(datafromfiles!=null){
				
				pathtoFiles = cf.getDirectory();
				foldername = cf.getDirectoryName();
				filesname = cf.getFilesName();
				lf.Separate(datafromfiles, partsfromfiles, " ");
				Folder folder; 
				DataFile df;
				List<Folder> fl;
				
				session.beginTransaction();
				
				fl = session.createQuery("from Folder").getResultList();
				for(Folder f:fl){
					if(f.getName().equals(foldername)){
						System.out.println("Folder name is already taken");
						
					}
					else{
						folder = new Folder(foldername);
						System.out.println("Adding datafiles to folder list");
						for(String[] s: partsfromfiles){
							df = new DataFile(s[0],s[1],s[2]);
							folder.addDataFile(df);
							session.save(df);
						}
						session.save(folder);
					}
				}
				
				session.getTransaction().commit();
				
				System.out.println("Done");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
			session.close();
			factory.close();
		}	
		
	}
}
