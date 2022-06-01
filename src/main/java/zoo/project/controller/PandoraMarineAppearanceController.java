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

import zoo.project.model.PandoraMarine;
import zoo.project.model.PandoraMarineAppearance;
import zoo.project.model.PandoraMarineEvents;
import zoo.project.model.PandoraPass;
import zoo.project.service.PandoraMarineAppearanceService;
import zoo.project.service.PandoraMarineEventsService;
import zoo.project.service.PandoraMarineService;
import zoo.project.service.PandoraPassService;

@Controller
public class PandoraMarineAppearanceController {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 
	
	@Autowired
	private PandoraMarineAppearanceService pandoraMarineAppearanceService;
	
	@Autowired
	private PandoraMarineService pandoraMarineService;
	
	@Autowired
	private PandoraMarineEventsService pandoraMarineEventsService;
	
	@Autowired
	private PandoraPassService pandoraPassService;
	
	@GetMapping("/addPandoraMarineAppearance")
	public String addAppearance(Model model) {
		model.addAttribute("MarineAppearance",new PandoraMarineAppearance());
		return "addPandoraMarineAppearance";
	}
	@GetMapping("/Pandora-Marine")
    public String MarinePage(Model model) {
		PandoraMarineAppearance appearance = pandoraMarineAppearanceService.showAll().get(0);
		model.addAttribute("appearance",appearance);
		List<PandoraMarine> animal = pandoraMarineService.showAll();
		model.addAttribute("animal",animal);
		List<PandoraMarineEvents> Events = pandoraMarineEventsService.showAll();
		model.addAttribute("Events",Events);
		List<PandoraPass> pass = pandoraPassService.showAll(); 
		model.addAttribute("pass",pass);
        return "Marine";
    }
	
	@PostMapping("/saveMarineAppearance/{id}/{fileName}")
	public String saving(  @Valid PandoraMarineAppearance pandoraMarineAppearance,final @RequestParam("file") MultipartFile file, @PathVariable("id") Long id,
			@PathVariable("fileName") String deletedFileName) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraMarineAppearance.setFileName(fileName);
			pandoraMarineAppearance.setFilePath(filePath);
			pandoraMarineAppearance.setFileType(fileType);
			pandoraMarineAppearanceService.removeAppearanceandFile(id, deletedFileName);
			
			pandoraMarineAppearanceService.addAppearance(pandoraMarineAppearance);
			
		
		return "redirect:/home";
	
	}
	@GetMapping("/updateMarineAppearance/{id}/{fileName}")
	public String updateAppearance(Model model, @PathVariable("id") Long id,
			@PathVariable("fileName") String deletedFileName) {
		model.addAttribute("MarineAppearance",new PandoraMarineAppearance());
		model.addAttribute("filename",deletedFileName);
		model.addAttribute("id",id);
		return "addPandoraMarineAppearance";
	}

}
