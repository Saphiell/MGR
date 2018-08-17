package magisterka.springfiles;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import magisterka.db.CreateData;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage(){
		
		
		return "main-menu";
	}
	@RequestMapping("/buttonForm")
	public String addData(HttpServletRequest request, Model model) throws Exception{
		CreateData cd = new CreateData();
		String param = (String)request.getParameter("button");
		System.out.println(param);
		if(param.equals("Add"))
			cd.addData();
		
		Thread.sleep(10000);
		return "main-menu";
	}
	
}
