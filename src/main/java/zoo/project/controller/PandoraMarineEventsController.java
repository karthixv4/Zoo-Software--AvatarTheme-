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

import zoo.project.model.PandoraMarineEvents;

import zoo.project.service.PandoraMarineEventsService;

@Controller
public class PandoraMarineEventsController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private PandoraMarineEventsService pandoraMarineEventsService;
	
	@GetMapping("/addPandoraMarineEvents")
	public String addEvents(Model model) {
		model.addAttribute("MarineEvents",new PandoraMarineEvents());
		return "addPandoraMarineEvents";
	}
	
	@PostMapping("/saveMarineEvents")
	public String saving( @Valid PandoraMarineEvents pandoraMarineEvents,final @RequestParam("file") MultipartFile file) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraMarineEvents.setFileName(fileName);
			pandoraMarineEvents.setFilePath(filePath);
			pandoraMarineEvents.setFileType(fileType);
			
			pandoraMarineEventsService.addEvents(pandoraMarineEvents);
			
		
		return "redirect:/home";
	
	}
	@GetMapping("/deleteMarineEvents/{id}/{deletedFileName}")
	public String deleteEvent(@PathVariable("id") Long id, @PathVariable("deletedFileName") String deletedFileName) {
		String path = null;
		File file =null;

			path = uploadDirectory + "/" + deletedFileName;
			file = new File(path);
			if(file.exists()) {
				
				pandoraMarineEventsService.removeMarineEventsandFile(id, deletedFileName);
				return "redirect:/adminPanel";
			
			}else {
				pandoraMarineEventsService.removeEvents(id);
			}
			return "home";
	}
}
