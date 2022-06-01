package zoo.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import zoo.project.model.PandoraWildEvents;

public interface PandoraWildEventsRepo extends JpaRepository<PandoraWildEvents, Long> {

	@Transactional
	  @Modifying
	  @Query("delete from PandoraWildEvents b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraWildEventsWithFile(Long id, String fileName);
}


