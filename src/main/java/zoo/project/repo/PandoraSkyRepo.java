package zoo.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import zoo.project.model.PandoraSky;



public interface PandoraSkyRepo extends JpaRepository<PandoraSky, Long> {

	@Transactional
	  @Modifying
	  @Query("delete from PandoraSky b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraSkyWithFile(Long id, String fileName);

}
