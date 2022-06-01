package zoo.project.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import zoo.project.model.PandoraUnitedAppearance;

public interface PandoraUnitedAppearanceRepo extends JpaRepository<PandoraUnitedAppearance, Long>{
	@Transactional
	  @Modifying
	  @Query("delete from PandoraUnitedAppearance b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraUnitedAppearanceWithFile(Long id, String fileName);
}
