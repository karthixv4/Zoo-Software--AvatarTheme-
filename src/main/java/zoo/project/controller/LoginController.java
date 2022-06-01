package zoo.project.controller;

import java.util.Arrays;
import java.util.HashSet;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import zoo.project.model.Role;
import zoo.project.model.Users;
import zoo.project.repo.RoleRepo;
import zoo.project.repo.UserRepo;




@Controller
public class LoginController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@GetMapping("/login")
	public ModelAndView showlogin() {
		ModelAndView modelAndView = new ModelAndView();
	
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@GetMapping("")
    public String viewHomePage() {
        return "login";
    }
	
	  @GetMapping("/register")
	    public String showRegistrationForm(Model model)  {
	    	
	        model.addAttribute("users", new Users());

	        return "register";
	    }
	   @PostMapping("/process_register")
	    public String processRegister(Users user,Model model) {
	    	String email = user.getEmail();
	    	
	    	if(userRepo.findByEmail(email) != null) {
	    		model.addAttribute("exist","An account already exists with this Email please Login");
	    		return "register";
	    		
	    	} else {
	    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    	    user.setPassword(encodedPassword);
	    	    Role userRole= roleRepo.findByName("user");
	    		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	    	    userRepo.save(user);
	        return "login";
	    	}
	    }
	   @GetMapping("/landing")
	    public String myAccount() {
	        return "adminpanel";
	    }
	
}
