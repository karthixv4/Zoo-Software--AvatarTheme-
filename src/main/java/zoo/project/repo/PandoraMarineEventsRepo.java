package zoo.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import zoo.project.model.PandoraMarineEvents;

public interface PandoraMarineEventsRepo extends JpaRepository<PandoraMarineEvents, Long> {

	@Transactional
	  @Modifying
	  @Query("delete from PandoraMarineEvents b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraMarineEventsWithFile(Long id, String fileName);
}


