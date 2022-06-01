package zoo.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import zoo.project.model.PandoraWild;


public interface PandoraWildRepo extends JpaRepository<PandoraWild, Long> {

	@Transactional
	  @Modifying
	  @Query("delete from PandoraWild b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraWildWithFile(Long id, String fileName);
}
