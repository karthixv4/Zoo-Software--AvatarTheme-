package zoo.project.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import zoo.project.model.PandoraSky;
import zoo.project.model.PandoraSkyAppearance;
import zoo.project.service.PandoraSkyService;

@Controller
public class PandoraSkyController {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 
	
	@Autowired
	private PandoraSkyService pandoraSkyService;
	
	@GetMapping("/addSkyAnimal")
	public String addAppearance(Model model) {
		model.addAttribute("pandoraSky",new PandoraSky());
		return "addPandoraSky";
	}

	
	@PostMapping("/saveSky")
	public String saving( @Valid PandoraSky pandoraSky,final @RequestParam("file") MultipartFile file) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraSky.setFileName(fileName);
			pandoraSky.setFilePath(filePath);
			pandoraSky.setFileType(fileType);
			
			pandoraSkyService.addAnimal(pandoraSky);
			
		
		return "redirect:/home";
	
	}
	@GetMapping("/deleteSkyAnimal/{id}/{deletedFileName}")
	public String deleteEvent(@PathVariable("id") Long id, @PathVariable("deletedFileName") String deletedFileName) {
		String path = null;
		File file =null;

			path = uploadDirectory + "/" + deletedFileName;
			file = new File(path);
			if(file.exists()) {
				
				pandoraSkyService.removeSkyandFile(id, deletedFileName);
				return "redirect:/adminPanel";
			
			}else {
				pandoraSkyService.removeAnimal(id);
			}
			return "home";
	}
	
}
