package magisterka.springfiles.controllers;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import magisterka.db.methods.CreateData;
import magisterka.db.methods.GetFromDB;
import magisterka.entity.Folder;
import magisterka.springfiles.services.FolderService;



@Controller
public class HomeController {

	private FolderService folderService;
	
	@Autowired(required=true)
	@Qualifier("folderService")
	public void setFolderService(FolderService folderService){
		this.folderService = folderService;
	}
	
	@RequestMapping("/")
	public String showPage(Model model){
		List<String> listoffoldernames = new ArrayList<>();
		GetFromDB dg = new GetFromDB();
		listoffoldernames = dg.GetFolders().stream().map(i -> i.getName()).collect(Collectors.toList());
		
		model.addAttribute("foldernames",listoffoldernames);
		model.addAttribute("folderForm", new Folder());
		model.addAttribute("fafa");
		
		return "main-menu";
	}
	@RequestMapping(value = "/buttonForm", method = RequestMethod.GET)
	public String addData(HttpServletRequest request, Model model) throws Exception{
		
		
		String param = (String)request.getParameter("button");
	 //	String foldername = (String)request.getParameter("folder");
		
		//System.out.println(fol.getName() );
		System.out.println(param);
		if(param.equals("Add"))
			this.folderService.addFolder();
		else if(param.equals("Delete"))
			this.folderService.deleteFolder("new");
		else
			{
			  model.addAttribute("folderForm", new Folder());
				
			}
		
		return showPage(model);
	}

	
}
