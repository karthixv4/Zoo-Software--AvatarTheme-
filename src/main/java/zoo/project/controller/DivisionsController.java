package zoo.project.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import zoo.project.model.PandoraDivisions;

import zoo.project.service.PandoraDivisionsService;

@Controller
public class DivisionsController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 

	@Autowired
	private PandoraDivisionsService pandoraDivisionsService;

	
	@GetMapping("/addDivisions")
	public String addDivisions(Model model) {
		model.addAttribute("divisions",new PandoraDivisions());
		return "addDivisions";
	}
	
	@PostMapping("/saveDivisions")
	public String saving( @Valid PandoraDivisions pandoraDivisions,final @RequestParam("file") MultipartFile file) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraDivisions.setFileName(fileName);
			pandoraDivisions.setFilePath(filePath);
			pandoraDivisions.setFileType(fileType);
			
			pandoraDivisionsService.addDivision(pandoraDivisions);
			
		
		return "redirect:/home";
	
	}
	
}
