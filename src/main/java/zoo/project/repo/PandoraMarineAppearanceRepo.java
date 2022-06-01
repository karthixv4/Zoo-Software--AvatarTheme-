package zoo.project.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import zoo.project.model.PandoraMarineAppearance;



public interface PandoraMarineAppearanceRepo extends JpaRepository<PandoraMarineAppearance, Long> {

	
	@Transactional
	  @Modifying
	  @Query("delete from PandoraMarineAppearance b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraMarineAppearanceWithFile(Long id, String fileName);

}
