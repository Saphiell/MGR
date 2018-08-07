package filesUtils;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ChooseFiles {

	 
	public String directory;
	public List<String> filesname;
	public File[] files;
	
	private LoadFiles lf = new LoadFiles();
	
	public List<String> FolderChooser(){
		 
		 Frame a = new Frame ("Choose Folder");
	     a.setBounds(20,20,400,500);
	     a.setVisible(false);
	   
	     
	     FileDialog fd =new FileDialog(a,"Load",FileDialog.LOAD);
	     fd.setMultipleMode(true);	     
	     fd.setVisible(true);
	     directory = fd.getDirectory();
	     if(directory != null){
	    	 
	     	files = fd.getFiles();
	     	return lf.load(fd.getFiles());
	     }
	     return null;
	}
	
	public String getDirectory(){
	
		return directory;
	}
	
	public File[] getFiles(){
		return files;
	}
	
	public String getDirectoryName(){
		String[] dir = lf.Separate(getDirectory().replaceAll("\\\\", ","),",");;
		return dir[dir.length-1];
	}
	
	
	//Nazwy plików mo¿e bêd¹ potrzebne by ewentualnie sprawdzaæ czy dany plik zosta³ ju¿ wczytany(do dogadania)
	public List<String> getFilesName(){
		filesname = new ArrayList<>();
		for(File f: getFiles()){
			System.out.println(f.getAbsolutePath());
			String[] dir = lf.Separate(f.getAbsolutePath().replaceAll("\\\\", ","),",");;
			filesname.add(dir[dir.length-1]);
			
		}
		
		return filesname;
	}
	
}
