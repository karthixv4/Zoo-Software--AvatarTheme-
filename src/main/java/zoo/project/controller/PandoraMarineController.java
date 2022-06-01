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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import zoo.project.model.PandoraMarine;
import zoo.project.service.PandoraMarineService;

@Controller
public class PandoraMarineController {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 
	
	@Autowired
	private PandoraMarineService pandoraMarineService;
	
	@GetMapping("/addMarineAnimal")
	public String addAppearance(Model model) {
		model.addAttribute("pandoraMarine",new PandoraMarine());
		return "addPandoraMarine";
	}

	
	@PostMapping("/saveMarine")
	public String saving( @Valid PandoraMarine pandoraMarine,final @RequestParam("file") MultipartFile file) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraMarine.setFileName(fileName);
			pandoraMarine.setFilePath(filePath);
			pandoraMarine.setFileType(fileType);
			
			pandoraMarineService.addAnimal(pandoraMarine);
			
		
		return "redirect:/home";
	
	}
	@GetMapping("/deleteMarineAnimal/{id}/{deletedFileName}")
	public String deleteEvent(@PathVariable("id") Long id, @PathVariable("deletedFileName") String deletedFileName) {
		String path = null;
		File file =null;

			path = uploadDirectory + "/" + deletedFileName;
			file = new File(path);
			if(file.exists()) {
				
				pandoraMarineService.removeMarineandFile(id, deletedFileName);
				return "redirect:/adminPanel";
			
			}else {
				pandoraMarineService.removeAnimal(id);
			}
			return "home";
	}
}
