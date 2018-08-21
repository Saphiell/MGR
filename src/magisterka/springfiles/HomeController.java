package magisterka.springfiles;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import magisterka.db.CreateData;
import magisterka.db.GetData;
import magisterka.entity.Folder;

@Controller

public class HomeController {

	@RequestMapping("/")
	public String showPage(Model model){
		model.addAttribute("folders",new Folder());
		
		return "main-menu";
	}
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
	
	@RequestMapping("/getFolders")
	public String getFolders( @ModelAttribute("folders") Folder folderfromSelect) throws Exception{
		String fold = folderfromSelect.getFolderName();
		return "main-menu";
	}
	
}
