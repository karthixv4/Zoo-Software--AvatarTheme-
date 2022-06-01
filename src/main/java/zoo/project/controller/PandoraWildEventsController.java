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

import zoo.project.model.PandoraWildEvents;

import zoo.project.service.PandoraWildEventsService;

@Controller
public class PandoraWildEventsController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private PandoraWildEventsService pandoraWildEventsService;
	
	@GetMapping("/addPandoraWildEvents")
	public String addEvents(Model model) {
		model.addAttribute("wildEvents",new PandoraWildEvents());
		return "addPandoraWildEvents";
	}
	
	@PostMapping("/saveWildEvents")
	public String saving( @Valid PandoraWildEvents pandoraWildEvents,final @RequestParam("file") MultipartFile file) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraWildEvents.setFileName(fileName);
			pandoraWildEvents.setFilePath(filePath);
			pandoraWildEvents.setFileType(fileType);
			
			pandoraWildEventsService.addEvents(pandoraWildEvents);
			
		
		return "redirect:/home";
	
	}
	@GetMapping("/deleteWildEvents/{id}/{deletedFileName}")
	public String deleteEvent(@PathVariable("id") Long id, @PathVariable("deletedFileName") String deletedFileName) {
		String path = null;
		File file =null;

			path = uploadDirectory + "/" + deletedFileName;
			file = new File(path);
			if(file.exists()) {
				
				pandoraWildEventsService.removeWildEventsandFile(id, deletedFileName);
				return "redirect:/adminPanel";
			
			}else {
				pandoraWildEventsService.removeEvents(id);
			}
			return "home";
	}
}
