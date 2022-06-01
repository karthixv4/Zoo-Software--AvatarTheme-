package zoo.project.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import zoo.project.model.PandoraTickets;
import zoo.project.model.TempHold;
import zoo.project.service.PandoraPassService;
import zoo.project.service.PandoraTicketsService;



@Controller
public class PandoraTicketsController {
	
	@Autowired
	private PandoraPassService pandoraPassService;
	@Autowired
	private PandoraTicketsService pandoraTicketsService;

	@GetMapping("/users/BuyTicket/{id}")
	public String buyticket(Model model,@PathVariable("id") Long id,Principal principal) {
		TempHold.hold.clear();
		model.addAttribute("ticket",new PandoraTickets());
		model.addAttribute("pass",pandoraPassService.getById(id).get());
		model.addAttribute("user",principal.getName());
		return "BuyTickets";
	}
	@PostMapping("/saveTickets")
	public String SavePass(PandoraTickets pandoraTickets) {
		TempHold.hold.add(pandoraTickets);
		return "redirect:/payment";
		
	}
	 @GetMapping("/payment")
	 public String payment(Model model){
		 model.addAttribute("ticket",TempHold.hold.get(0));
		return "payment";
	 }
	 @GetMapping("/redirect/payment")
	 public String gateway(Model model) {
		 return "gateway";
	 }
	 @GetMapping("/buyTicket")
	 public String done(Model model) {
		 PandoraTickets ticket = TempHold.hold.get(0);
		 pandoraTicketsService.addTickets(ticket);
		 TempHold.hold.clear();
		 return "redirect:/home";
	 }
	 @GetMapping("/viewTickets")
	 public String viewTicket(Principal principal,Model model) {
		 String user = principal.getName();
		List<PandoraTickets> tickets = pandoraTicketsService.getTicketsByUser(user);
		model.addAttribute("tickets",tickets);
		 return "viewTicket";
	 }
	 
}

