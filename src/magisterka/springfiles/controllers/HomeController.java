package magisterka.springfiles.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import magisterka.entity.DataFile;
import magisterka.entity.Folder;
import magisterka.models.ComputedData;
import magisterka.models.SingleValue;
import magisterka.springfiles.services.FolderService;



@Controller
public class HomeController {

	private FolderService folderService;
	
	private int selectedId = 0;
	DataFile oneDataFile;
	
	@Autowired(required=true)
	@Qualifier("folderService")
	public void setFolderService(FolderService folderService){
		this.folderService = folderService;
	}
	
	@RequestMapping("/")
	public String showPage(Model model){
	
		model.addAttribute("folders",folderService.listFolders());
		model.addAttribute("folderForm", new Folder());
		
		return "main-menu";
	}

	@RequestMapping(params="Add", value= "/getfoldernames")
	public String addFolder(SessionStatus status){
		this.folderService.addFolder();
	
		return "redirect:/";
	}
	
	@RequestMapping(params="Delete", value= "/getfoldernames",method = RequestMethod.POST)
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
	

	@RequestMapping(params="Save", value="/getDescription")
	public String saveDescriptionAndData(@RequestParam("descriptionField") String description, SessionStatus status){
		//this.folderService.addFolder();
		
		int selectedId = this.selectedId;
		System.out.println("Description: "+description+ " and the id is: "+selectedId);
		this.folderService.updateFolderWithDescription(selectedId, description);
	
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/getModels", method = RequestMethod.GET)
	@ResponseBody
	public String getModels(@RequestParam("id") int theId, @RequestParam("iReflectance") double iReflectance, @RequestParam("jReflectance") int jReflectance){
		//this.folderService.addFolder();
		//System.out.println("Id of selected item" + theId);
		
		List<DataFile> data = this.folderService.getDataForFolder(theId);
			
		List<SingleValue> valuesFromData = data.stream().map(listItem -> {
		  
			return new SingleValue(
				  Double.parseDouble(listItem.getCordx()),
				  Double.parseDouble(listItem.getCordy()),
				  Double.parseDouble(listItem.getDepth()));
					
		}).collect(Collectors.toList());
		System.out.println(theId);
		for(int i = 0;i<1000;i++) {
		System.out.println(valuesFromData.get(i).toString());
		}
		ArrayList<ComputedData> computedData = new ArrayList<>();
		
		//this.selectedId=theId;
	
		//call methods for model computing and add result to object
		//parse object to json
		return "123";
	}
	
}
