package magisterka.springfiles.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		model.addAttribute("folders",new Folder());
		
		return "main-menu";
	}
	@RequestMapping(value = "/buttonForm", method = RequestMethod.GET)
	public String addData(HttpServletRequest request, Model model) throws Exception{
		
		CreateData cd = new CreateData();
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
		Thread.sleep(10000);

		return "main-menu";
	}
	
	//@RequestMapping("/getFolders")
	public String getFolders(Model model){
		
		//List<String> listoffoldernames = new ArrayList<>();
		//listoffoldernames.add("blalba");
		
		//model.addAttribute("foldernames", listoffoldernames);
		//System.out.println(listoffoldernames.size());
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
