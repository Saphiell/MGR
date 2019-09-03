package magisterka;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import magisterka.db.FolderDAOImpl;
import magisterka.db.methods.CreateData;
import magisterka.db.methods.DeleteData;
import magisterka.db.methods.GetFromDB;
import magisterka.entity.Folder;

public class main {

	public static void main(String[] args) {
		
		GetFromDB gdb= new GetFromDB();
		FolderDAOImpl dasd = new FolderDAOImpl();
		List<Folder> fads = dasd.listFolders();
		Folder f = gdb.getDataUsingFolderName("Dane pomiarowe");
		
		StumpfCalibration s = new StumpfCalibration();
		double[] a = {1,2,3};
		s.CalibrateStumpf(new HashMap<Point,Double>(), 0 ,0);
	}

}
