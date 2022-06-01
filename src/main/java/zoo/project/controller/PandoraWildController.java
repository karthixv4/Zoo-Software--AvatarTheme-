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

import zoo.project.model.PandoraWild;
import zoo.project.service.PandoraWildService;

@Controller
public class PandoraWildController {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 
	
	@Autowired
	private PandoraWildService pandoraWildService;
	
	@GetMapping("/addWildAnimal")
	public String addAppearance(Model model) {
		model.addAttribute("pandoraWild",new PandoraWild());
		return "addPandoraWild";
	}

	
	@PostMapping("/saveWild")
	public String saving( @Valid PandoraWild pandoraWild,final @RequestParam("file") MultipartFile file) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraWild.setFileName(fileName);
			pandoraWild.setFilePath(filePath);
			pandoraWild.setFileType(fileType);
			
			pandoraWildService.addAnimal(pandoraWild);
			
		
		return "redirect:/home";
	
	}
	@GetMapping("/deleteWildAnimal/{id}/{deletedFileName}")
	public String deleteEvent(@PathVariable("id") Long id, @PathVariable("deletedFileName") String deletedFileName) {
		String path = null;
		File file =null;

			path = uploadDirectory + "/" + deletedFileName;
			file = new File(path);
			if(file.exists()) {
				
				pandoraWildService.removeWildandFile(id, deletedFileName);
				return "redirect:/adminPanel";
			
			}else {
				pandoraWildService.removeAnimal(id);
			}
			return "home";
	}
}

