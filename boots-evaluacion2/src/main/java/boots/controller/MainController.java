package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Seller;
import boots.model.Sport;
import boots.model.Task;
import boots.service.SellerService;
import boots.service.SportService;
import boots.service.TaskService;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	
	@GetMapping("/task")
	public String task(HttpServletRequest request){
		request.setAttribute("mode", "MODE_TASK");
		return "task";
	}
	
	@GetMapping("/sport")
	public String sport(HttpServletRequest request){
		request.setAttribute("mode", "MODE_SPORT");
		return "sport";
	}
	
	@GetMapping("/seller")
	public String seller(HttpServletRequest request){
		request.setAttribute("mode", "MODE_SELLER");
		return "seller";
	}
	
	
}
