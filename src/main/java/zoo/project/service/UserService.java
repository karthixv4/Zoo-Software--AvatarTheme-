package zoo.project.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import zoo.project.model.Users;
import zoo.project.repo.UserRepo;


@Service
public class UserService {
	@Autowired
private UserRepo userRepo;

public List<Users> showAllUsers(){
	
		return userRepo.findAll();
	
}
public void addUser(Users user) {
	userRepo.save(user);
}
public void removeUser(Long id) {
	userRepo.deleteById(id);
}

public Optional<Users> getUsersId(Long id) {
    return userRepo.findById(id);
}

public Users get(Long id) {
	return userRepo.findById(id).get();
}



}
