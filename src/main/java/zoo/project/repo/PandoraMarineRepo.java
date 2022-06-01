package zoo.project.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import zoo.project.model.PandoraMarine;


public interface PandoraMarineRepo extends JpaRepository<PandoraMarine, Long> {
	@Transactional
	  @Modifying
	  @Query("delete from PandoraMarine b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraMarineWithFile(Long id, String fileName);

}
