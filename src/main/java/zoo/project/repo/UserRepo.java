package zoo.project.repo;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import zoo.project.model.Users;



@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
	 @Query("SELECT u FROM Users u WHERE u.email = ?1")
	    public Users findByEmail(String email);
	 
	 @Query("SELECT u FROM Users u WHERE u.firstName LIKE %?1%" + " OR u.lastName LIKE %?1%" )
	 public List<Users> findAll(String keyword);
	 @Transactional
	 @Modifying
	 @Query(value="DELETE  FROM Users u WHERE u.id = ?1")
	 public void deleteById(Long id);
	     
}
