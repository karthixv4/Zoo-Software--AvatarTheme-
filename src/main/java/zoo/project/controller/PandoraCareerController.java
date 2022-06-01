package zoo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import zoo.project.model.PandoraCareer;
import zoo.project.service.PandoraCareerService;

@Controller
public class PandoraCareerController {

	@Autowired
	private PandoraCareerService pandoraCareerService;
	
	@GetMapping("/addCareer")
	public String addDivisions(Model model) {
		model.addAttribute("pandoraCareer",new PandoraCareer());
		return "addPandoraCareer";
	}
	
	@PostMapping("/saveCareer/{id}")
	public String SaveCareer(PandoraCareer pandoraCareer,@PathVariable("id") Long id) {
		pandoraCareerService.removeCareer(id);
		pandoraCareerService.addCareer(pandoraCareer);
		return "redirect:/admin/PandoraCareerList";
		
	}	
	@GetMapping("/updatePandoraCareers/{id}")
	public String update(Model model, @PathVariable("id") Long id) {
		model.addAttribute("pandoraCareer",new PandoraCareer());
		model.addAttribute("id",id);
		return "addPandoraCareer";
	}
	
}
