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

import zoo.project.model.PandoraCareer;
import zoo.project.model.PandoraDivisions;
import zoo.project.model.PandoraPass;
import zoo.project.model.PandoraSkyAppearance;
import zoo.project.model.PandoraUnitedAppearance;
import zoo.project.service.PandoraCareerService;
import zoo.project.service.PandoraDivisionsService;
import zoo.project.service.PandoraPassService;
import zoo.project.service.PandoraUnitedAppearanceService;



@Controller
public class PandoraUnitedAppearanceController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads"; 
	
	@Autowired
	private PandoraUnitedAppearanceService pandoraUnitedAppearanceService;
	
	@Autowired
	private PandoraPassService pandoraPassService;
	
	@Autowired
	private PandoraDivisionsService pandoraDivisionsService;
	@Autowired
	private PandoraCareerService pandoraCareerService;
	
	
	
	@GetMapping("/addPandoraUnitedAppearance")
	public String addAppearance(Model model) {
		model.addAttribute("UnitedAppearance",new PandoraUnitedAppearance());
		
		return "addPandoraUnitedAppearance";
	}
	@GetMapping("/home")
    public String UnitedPage(Model model) {
		PandoraUnitedAppearance appearance = pandoraUnitedAppearanceService.showAll().get(0);
		model.addAttribute("appearance",appearance);
		List<PandoraPass> pass = pandoraPassService.showAll(); 
		model.addAttribute("pass",pass);
		List<PandoraDivisions> divisions = pandoraDivisionsService.showAllDivisions(); 
		model.addAttribute("divisions",divisions);
		PandoraCareer Career = pandoraCareerService.showAll().get(0); 
		model.addAttribute("career",Career);
		
	
		
        return "index";
    }
	
	@PostMapping("/saveUnitedAppearance/{id}/{fileName}")
	public String saving( @Valid PandoraUnitedAppearance pandoraUnitedAppearance,final @RequestParam("file") MultipartFile file, @PathVariable("id") Long id,
			@PathVariable("fileName") String deletedFileName) 
			throws IOException {
		
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();

			
			pandoraUnitedAppearance.setFileName(fileName);
			pandoraUnitedAppearance.setFilePath(filePath);
			pandoraUnitedAppearance.setFileType(fileType);
			pandoraUnitedAppearanceService.removeAppearanceandFile(id, deletedFileName);
			
			pandoraUnitedAppearanceService.addAppearance(pandoraUnitedAppearance);
			
		
		return "redirect:/home";
	
	}
	@GetMapping("/updateHomePageAppearance/{id}/{fileName}")
	public String updateAppearance(Model model, @PathVariable("id") Long id,
			@PathVariable("fileName") String deletedFileName) {
		model.addAttribute("UnitedAppearance",new PandoraUnitedAppearance());
		model.addAttribute("filename",deletedFileName);
		model.addAttribute("id",id);
		return "addPandoraUnitedAppearance";
	}
}
