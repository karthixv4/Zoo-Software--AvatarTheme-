
package zoo.project.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import zoo.project.model.PandoraPass;
import zoo.project.model.PandoraWild;
import zoo.project.model.PandoraWildAppearance;
import zoo.project.model.PandoraWildEvents;
import zoo.project.service.PandoraPassService;
import zoo.project.service.PandoraWildAppearanceService;
import zoo.project.service.PandoraWildEventsService;
import zoo.project.service.PandoraWildService;


@Controller
public class PandoraWildAppearanceController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 
	
	@Autowired
	private PandoraWildAppearanceService pandoraWildAppearanceService;
	
	@Autowired
	private PandoraWildService pandoraWildService;
	
	@Autowired
	private PandoraWildEventsService pandoraWildEventsService;
	
	@Autowired
	private PandoraPassService pandoraPassService;
	
	@GetMapping("/addPandoraWildAppearance")
	public String addAppearance(Model model) {
		model.addAttribute("wildAppearance",new PandoraWildAppearance());
		return "addPandoraWildAppearance";
	}
	@GetMapping("/Pandora-Wild")
    public String WildPage(Model model) {
		PandoraWildAppearance appearance = pandoraWildAppearanceService.showAll().get(0);
		model.addAttribute("appearance",appearance);
		System.out.println(appearance.getHeadingOne());
		List<PandoraWild> animal = pandoraWildService.showAll();
		model.addAttribute("animal",animal);
		System.out.println(animal);
		List<PandoraWildEvents> Events = pandoraWildEventsService.showAll();
		model.addAttribute("Events",Events);
		List<PandoraPass> pass = pandoraPassService.showAll(); 
		model.addAttribute("pass",pass);
        return "Wild";
    }
	
	@PostMapping("/saveWildAppearance/{id}/{fileName}")
	public String saving( @Valid PandoraWildAppearance pandoraWildAppearance,final @RequestParam("file") MultipartFile file, @PathVariable("id") Long id,
			@PathVariable("fileName") String deletedFileName) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraWildAppearance.setFileName(fileName);
			pandoraWildAppearance.setFilePath(filePath);
			pandoraWildAppearance.setFileType(fileType);
			pandoraWildAppearanceService.removeAppearanceandFile(id, deletedFileName);
			pandoraWildAppearanceService.addAppearance(pandoraWildAppearance);
			
		
		return "redirect:/home";
	
	}
	@GetMapping("/updateWildAppearance/{id}/{fileName}")
	public String updateAppearance(Model model, @PathVariable("id") Long id,
			@PathVariable("fileName") String deletedFileName) {
		model.addAttribute("wildAppearance",new PandoraWildAppearance());
		model.addAttribute("filename",deletedFileName);
		model.addAttribute("id",id);
		return "addPandoraWildAppearance";
	}
}
