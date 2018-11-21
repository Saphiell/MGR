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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

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
	
		model.addAttribute("folders",folderService.listFolders());
		model.addAttribute("folderForm", new Folder());
		
		//model.addAttribute("fafa");
		
		return "main-menu";
	}
	@RequestMapping(value = "/getfoldernames")
	public String addData(@ModelAttribute("folder") Folder theFolder, HttpServletRequest request, Model model) throws Exception{
		
		
		String param = (String)request.getParameter("button");
		System.out.println(param);
		if(param.equals("Add"))
			this.folderService.addFolder();
		else if(param.equals("Delete"))
			this.folderService.deleteFolder(6);
		else
			{
			  model.addAttribute("folderForm", new Folder());
				
			}
		
		return showPage(model);
	}
	/*
	 * <!-- @RequestMapping(params = "save", method = RequestMethod.POST)
public String saveUser(HttpServletRequest request, @ModelAttribute User user, BindingResult result, SessionStatus status) {
    // validate your result
    // if no errors, save it and redirect to successView.
} -->
	 */
	
	
	@RequestMapping(params="Add", value= "/getfoldernames")
	public String addFolder(SessionStatus status){
		this.folderService.addFolder();
	
		return "redirect:/";
	}
	@RequestMapping(params="Delete", value= "/getfoldernames")
	public String deleteFolder(@RequestParam("id") int theId, SessionStatus status){
		System.out.println(theId);
		try{
			this.folderService.deleteFolder(theId);
		}
		catch(Exception e){
			e.getStackTrace();
		}
		
		return "redirect:/";
	}
	@RequestMapping(params="Get", value= "/getfoldernames")
	public String getFolderData(@RequestParam("id") int theId, SessionStatus status){
		this.folderService.addFolder();
	
		return "redirect:/";
	}

	
}
