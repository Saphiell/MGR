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
		Map<String, Object> map = new HashMap<String,Object>();
		
		model.addAttribute("foldernames",listoffoldernames);
		model.addAttribute("folderForm", new Folder());
	
		
		return "main-menu";
	}
	@RequestMapping(value = "/buttonForm", method = RequestMethod.GET)
	public String addData(HttpServletRequest request, Model model) throws Exception{
		
		
		String param = (String)request.getParameter("button");
		System.out.println(param);
		if(param.equals("Add"))
			this.folderService.addFolder();
		else if(param.equals("Delete"))
			this.folderService.deleteFolder("Dane Pomiarowe");
		else
			{
			  model.addAttribute("folder", new Folder());
				
			}
		

		return "main-menu";
	}
	
	@RequestMapping(value = "/getfoldernames", method = RequestMethod.GET)
	public String getFolders(@RequestParam String folderName, Model model, @ModelAttribute("folderForm") Folder folder) throws Exception{
		
		
		return "main-menu";
	}
	/*
	<form:form action = "getFolders" modelAttribute = "folders"  method="POST">
				<form:select path="folderName">
						<form:option value="0" label="Select an Option" />
						<form:options items = "${foldenames}"/>
				</form:select>
			</form:form>
	
	*/
}
