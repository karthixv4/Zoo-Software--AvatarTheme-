package zoo.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraTickets;
import zoo.project.repo.PandoraTicketsRepo;



@Service
public class PandoraTicketsService {
	@Autowired
	private PandoraTicketsRepo pandoraTicketsRepo;
	
	public void addTickets(PandoraTickets pandoraTickets) {
		pandoraTicketsRepo.save(pandoraTickets);
	}
	public void removeTickets(Long id) {
		pandoraTicketsRepo.deleteById(id);
	}
	public List<PandoraTickets> getTicketsByUser(String user){
		return pandoraTicketsRepo.findAll(user);
		}
	public List<PandoraTickets> showAllTickets(){
		
		return pandoraTicketsRepo.findAll();
	}
}
