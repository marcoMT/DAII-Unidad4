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

	@Autowired
	private TaskService taskService;
	
	
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
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "task";
	}
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "task";
	}
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("task", taskService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "task";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id,HttpServletRequest request){
		taskService.delete(id);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "task";
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Task task,
			BindingResult bindingResult,HttpServletRequest request){
		taskService.save(task);
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "task";
		
	}
	
	@Autowired
	private SportService sportService;
	
	@GetMapping("/all-sports")
	public String allSports(HttpServletRequest request){
		request.setAttribute("sports", sportService.findAll());
		request.setAttribute("mode", "MODE_SPORTS");
		return "sport";
	}
	
	@GetMapping("/new-sport")
	public String newSport(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_SPORT");
		return "sport";
	}
	
	@GetMapping("/update-sport")
	public String updateSport(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("sport", sportService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_SPORT");
		return "sport";
	}
	
	@GetMapping("/delete-sport")
	public String deleteSport(@RequestParam int id,HttpServletRequest request){
		sportService.delete(id);
		request.setAttribute("sports", sportService.findAll());
		request.setAttribute("mode", "MODE_SPORTS");
		return "sport";
	}
	
	@PostMapping("/save-sport")
	public String saveSport(@ModelAttribute Sport sport,
			BindingResult bindingResult,HttpServletRequest request){
		sportService.save(sport);
		request.setAttribute("sports", sportService.findAll());
		request.setAttribute("mode", "MODE_SPORTS");
		return "sport";
		
	}
	
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/all-sellers")
	public String allSellers(HttpServletRequest request){
		request.setAttribute("sellers", sellerService.findAll());
		request.setAttribute("mode", "MODE_SELLERS");
		return "seller";
	}
	
	@GetMapping("/new-seller")
	public String newSeller(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_SELLER");
		return "seller";
	}
	
	@GetMapping("/update-seller")
	public String updateSeller(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("seller", sellerService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_SELLER");
		return "seller";
	}
	
	@GetMapping("/delete-seller")
	public String deleteSeller(@RequestParam int id,HttpServletRequest request){
		sellerService.delete(id);
		request.setAttribute("sellers", sellerService.findAll());
		request.setAttribute("mode", "MODE_SELLERS");
		return "seller";
	}
	
	@PostMapping("/save-seller")
	public String saveSeller(@ModelAttribute Seller seller,
			BindingResult bindingResult,HttpServletRequest request){
		sellerService.save(seller);
		request.setAttribute("sellers", sellerService.findAll());
		request.setAttribute("mode", "MODE_SELLERS");
		return "seller";
		
	}
	
}
