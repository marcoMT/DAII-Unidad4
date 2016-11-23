package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Sport;
import boots.service.SportService;

@Controller
public class SportController {

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
	
}
