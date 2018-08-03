package webtools;

import java.awt.FileDialog;
import java.awt.Frame;

public class blabwgwda {

	public String FolderChooser(){
		
		 Frame a = new Frame ("Choose Folder");
	     a.setBounds(20,20,400,500);
	     a.setVisible(false);
	   

	     FileDialog fd =new FileDialog(a,"Load",FileDialog.LOAD);
	   // Ewentualnie: FileDialog fd =new FileDialog(a,"Zapisz",FileDialog.SAVE);
	     fd.setVisible(true);
	     String directory=fd.getDirectory();
	     String file=fd.getFile();
	     System.out.println("Wybrano plik: " + file);
	     System.out.println("w katalogu: "+ directory);
	     System.out.println("Œcie¿ka: "+ directory + file); 
			
	     return directory;
	}
	
}
