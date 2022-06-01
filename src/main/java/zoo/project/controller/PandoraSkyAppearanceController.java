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
import zoo.project.model.PandoraSky;
import zoo.project.model.PandoraSkyAppearance;
import zoo.project.model.PandoraSkyEvents;
import zoo.project.model.PandoraWildAppearance;
import zoo.project.service.PandoraPassService;
import zoo.project.service.PandoraSkyAppearanceService;
import zoo.project.service.PandoraSkyEventsService;
import zoo.project.service.PandoraSkyService;

@Controller
public class PandoraSkyAppearanceController {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 

	
	@Autowired
	private PandoraSkyAppearanceService pandoraSkyAppearanceService;
	
	@Autowired
	private PandoraSkyService pandoraSkyService;
	
	@Autowired
	private PandoraSkyEventsService pandoraSkyEventsService;
	
	@Autowired
	private PandoraPassService pandoraPassService;
	
	@GetMapping("/addPandoraSkyAppearance")
	public String addAppearance(Model model) {
		model.addAttribute("skyAppearance",new PandoraSkyAppearance());
		return "addPandoraSkyAppearance";
	}
	@PostMapping("/saveSkyAppearance/{id}/{fileName}")
	public String saving( @Valid PandoraSkyAppearance pandoraSkyAppearance,final @RequestParam("file") MultipartFile file, @PathVariable("id") Long id,
			@PathVariable("fileName") String deletedFileName) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraSkyAppearance.setFileName(fileName);
			pandoraSkyAppearance.setFilePath(filePath);
			pandoraSkyAppearance.setFileType(fileType);
			pandoraSkyAppearanceService.removeAppearanceandFile(id, deletedFileName);
			
			pandoraSkyAppearanceService.addAppearance(pandoraSkyAppearance);
			
		
		return "redirect:/home";
	
	}
	@GetMapping("/Pandora-Sky")
    public String SkyPage(Model model) {
		PandoraSkyAppearance appearance = pandoraSkyAppearanceService.showAll().get(0);
		model.addAttribute("appearance",appearance);
		List<PandoraSkyEvents> Events = pandoraSkyEventsService.showAll();
		model.addAttribute("Events",Events);
		List<PandoraSky> animal = pandoraSkyService.showAll();
		model.addAttribute("animal",animal);
		List<PandoraPass> pass = pandoraPassService.showAll(); 
		model.addAttribute("pass",pass);
		
        return "Sky";
    }
	@GetMapping("/updateSkyAppearance/{id}/{fileName}")
	public String updateAppearance(Model model, @PathVariable("id") Long id,
			@PathVariable("fileName") String deletedFileName) {
		model.addAttribute("SkyAppearance",new PandoraSkyAppearance());
		model.addAttribute("filename",deletedFileName);
		model.addAttribute("id",id);
		return "addPandoraSkyAppearance";
	}
	
}
