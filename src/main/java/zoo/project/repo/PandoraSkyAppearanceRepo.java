package zoo.project.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import zoo.project.model.PandoraSkyAppearance;

public interface PandoraSkyAppearanceRepo extends JpaRepository<PandoraSkyAppearance, Long> {
	@Transactional
	  @Modifying
	  @Query("delete from PandoraSkyAppearance b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraSkyAppearanceWithFile(Long id, String fileName);
}
