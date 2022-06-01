package zoo.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import zoo.project.model.PandoraPass;

public interface PandoraPassRepo extends JpaRepository<PandoraPass, Long>  {

}
