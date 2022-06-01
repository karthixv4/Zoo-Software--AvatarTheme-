package zoo.project.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import zoo.project.model.PandoraWildAppearance;



public interface PandoraWildAppearanceRepo extends JpaRepository<PandoraWildAppearance, Long> {

	
	@Transactional
	  @Modifying
	  @Query("delete from PandoraWildAppearance b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraWildAppearanceWithFile(Long id, String fileName);
}
