package zoo.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import zoo.project.model.PandoraTickets;

public interface PandoraTicketsRepo extends JpaRepository< PandoraTickets, Long> {

	@Query(value="SELECT a FROM PandoraTickets a WHERE users LIKE %?1%")
	public List<PandoraTickets> findAll(String user);
	

}
