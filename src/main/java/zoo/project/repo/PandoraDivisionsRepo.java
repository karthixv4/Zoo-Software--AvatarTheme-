package zoo.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import zoo.project.model.PandoraDivisions;



public interface PandoraDivisionsRepo extends JpaRepository<PandoraDivisions, Long>  {
	
	@Transactional
	  @Modifying
	  @Query("delete from PandoraDivisions b where b.Id like ?1 and fileName like ?2") 
	  public void deletePandoraDivisionsWithFile(Long id, String fileName);

}
