package zoo.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import zoo.project.model.PandoraPass;
import zoo.project.service.PandoraPassService;



@Controller
public class PandoraPassController {
	
	@Autowired
	private PandoraPassService pandoraPassService;
	
	@GetMapping("/addPass")
	public String addDivisions(Model model) {
		model.addAttribute("pandoraPass",new PandoraPass());
		return "addPandoraPass";
	}
	
	@PostMapping("/savePass")
	public String SavePass(PandoraPass pandoraPass) {
		pandoraPassService.addPass(pandoraPass);
		return "redirect:/home";
		
	}
	@GetMapping("/deletePass/{id}")
	public String delete(@PathVariable("id") Long id) {
		pandoraPassService.removeAnimal(id);
		return "redirect:/admin/PandoraPassList";
		
	}

}

