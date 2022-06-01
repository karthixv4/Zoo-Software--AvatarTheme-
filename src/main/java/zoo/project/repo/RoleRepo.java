package zoo.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.project.model.Role;




@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

	public Role findByName(String name);

}
