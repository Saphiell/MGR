package magisterka.springfiles;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import magisterka.db.CreateData;
import magisterka.entity.Folder;

@RequestMapping("/folder")
public class FolderController {

	
	@RequestMapping("/buttonForm")
	public String addData(HttpServletRequest request, Model model) throws Exception{
		CreateData cd = new CreateData();
		String param = (String)request.getParameter("button");
		System.out.println(param);
		if(param.equals("Add"))
			cd.addData();
		else if(param.equals("Delete"))
			System.out.println("Deleting");
		else
			{
				Folder fl = new Folder();
				//List<String> foldernames = fl.getFoldernames();
			}
		Thread.sleep(10000);
		return "main-menu";
	}
}
