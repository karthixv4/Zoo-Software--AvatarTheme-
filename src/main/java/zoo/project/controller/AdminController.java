package zoo.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import zoo.project.model.PandoraCareer;
import zoo.project.model.PandoraMarine;
import zoo.project.model.PandoraMarineAppearance;
import zoo.project.model.PandoraMarineEvents;
import zoo.project.model.PandoraPass;
import zoo.project.model.PandoraSky;
import zoo.project.model.PandoraSkyAppearance;
import zoo.project.model.PandoraSkyEvents;
import zoo.project.model.PandoraTickets;
import zoo.project.model.PandoraUnitedAppearance;
import zoo.project.model.PandoraWild;
import zoo.project.model.PandoraWildAppearance;
import zoo.project.model.PandoraWildEvents;
import zoo.project.model.Users;
import zoo.project.service.PandoraCareerService;
import zoo.project.service.PandoraMarineAppearanceService;
import zoo.project.service.PandoraMarineEventsService;
import zoo.project.service.PandoraMarineService;
import zoo.project.service.PandoraPassService;
import zoo.project.service.PandoraSkyAppearanceService;
import zoo.project.service.PandoraSkyEventsService;
import zoo.project.service.PandoraSkyService;
import zoo.project.service.PandoraTicketsService;
import zoo.project.service.PandoraUnitedAppearanceService;
import zoo.project.service.PandoraWildAppearanceService;
import zoo.project.service.PandoraWildEventsService;
import zoo.project.service.PandoraWildService;
import zoo.project.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private PandoraUnitedAppearanceService pandoraUnitedAppearanceService;
	
	@Autowired
	private PandoraSkyAppearanceService pandoraSkyAppearanceService;
	
	@Autowired
	private PandoraWildAppearanceService pandoraWildAppearanceService;
	
	@Autowired
	private PandoraMarineAppearanceService pandoraMarineAppearanceService;
	
	@Autowired
	private PandoraSkyService pandoraSkyService;
	
	@Autowired
	private PandoraWildService pandoraWildService;
	
	@Autowired
	private PandoraMarineService pandoraMarineService;
	
	@Autowired
	private PandoraSkyEventsService pandoraSkyEventsService ;
	
	@Autowired
	private PandoraWildEventsService pandoraWildEventsService ;
	
	@Autowired
	private PandoraMarineEventsService pandoraMarineEventsService ;
	
	@Autowired
	private PandoraPassService pandoraPassService ;
	
	@Autowired
	private PandoraCareerService pandoraCareerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PandoraTicketsService pandoraTicketsService;
	

	@GetMapping("/admin/adminPanel")
	public String showadmin(Model model) {
		return "admin";
	}
	@GetMapping("/admin/HomePageAppearance")
	public String HomePageAppearance(Model model) {
		PandoraUnitedAppearance appearance = pandoraUnitedAppearanceService.showAll().get(0);
		model.addAttribute("appearance",appearance);
		return "HomePageList";
	}
	@GetMapping("/admin/SkyPageAppearance")
	public String SkyPageAppearance(Model model) {
		PandoraSkyAppearance appearance = pandoraSkyAppearanceService.showAll().get(0);
		model.addAttribute("appearance",appearance);
		return "PandoraSKyPageList";
	}
	@GetMapping("/admin/WildPageAppearance")
	public String WildPageAppearance(Model model) {
		PandoraWildAppearance appearance = pandoraWildAppearanceService.showAll().get(0);
		model.addAttribute("appearance",appearance);
		return "PandoraWildPageList";
	}
	@GetMapping("/admin/MarinePageAppearance")
	public String MarinePageAppearance(Model model) {
       PandoraMarineAppearance appearance = pandoraMarineAppearanceService.showAll().get(0);
		model.addAttribute("appearance",appearance);
		return "PandoraMarinePageList";
	}
	@GetMapping("/admin/SkyAnimalsList")
	public String SkyAnimalsList(Model model) {
       List<PandoraSky> animal = pandoraSkyService.showAll();
		model.addAttribute("appearance",animal);
		return "PandoraSkyAnimalsList";
	}
	@GetMapping("/admin/WildAnimalsList")
	public String WildAnimalsList(Model model) {
       List<PandoraWild> animal = pandoraWildService.showAll();
		model.addAttribute("appearance",animal);
		return "PandoraWildAnimalsList";
	}
	@GetMapping("/admin/MarineAnimalsList")
	public String MarineAnimalsList(Model model) {
       List<PandoraMarine> animal = pandoraMarineService.showAll();
		model.addAttribute("appearance",animal);
		return "PandoraMarineAnimalsList";
	}
	@GetMapping("/admin/SkyEventsList")
	public String SkyEventsList(Model model) {
       List<PandoraSkyEvents> events = pandoraSkyEventsService.showAll();
		model.addAttribute("appearance",events);
		return "PandoraSkyEventsList";
	}
	
	@GetMapping("/admin/WildEventsList")
	public String WildEventsList(Model model) {
       List<PandoraWildEvents> events = pandoraWildEventsService.showAll();
		model.addAttribute("appearance",events);
		return "PandoraWildEventsList";
	}
	@GetMapping("/admin/MarineEventsList")
	public String MarineEventsList(Model model) {
       List<PandoraMarineEvents> events = pandoraMarineEventsService.showAll();
		model.addAttribute("appearance",events);
		return "PandoraMarineEventsList";
	}
	
	@GetMapping("/admin/PandoraPassList")
	public String PandoraPassList(Model model) {
       List<PandoraPass> pass = pandoraPassService.showAll();
		model.addAttribute("appearance",pass);
		return "PandoraPass";
	}
	@GetMapping("/admin/PandoraCareerList")
	public String PandoraCareerList(Model model) {
       PandoraCareer Career = pandoraCareerService.showAll().get(0);
		model.addAttribute("appearance",Career);
		return "PandoraCareerList";
	}
	@GetMapping("/admin/viewUsers")
	public String Users(Model model) {
		List<Users> listUsers = userService.showAllUsers();
        model.addAttribute("appearance", listUsers);
         
        return "PandoraUsersList";
	}
	@GetMapping("/admin/PandoraBookings")
	public String showticket(Model model) {
		List<PandoraTickets> tickets = pandoraTicketsService.showAllTickets();
		model.addAttribute("tickets",tickets);
		 return "viewTicket";
	}
	
}
