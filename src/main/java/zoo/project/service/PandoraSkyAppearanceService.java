package zoo.project.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraSkyAppearance;

import zoo.project.repo.PandoraSkyAppearanceRepo;

@Service
public class PandoraSkyAppearanceService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private PandoraSkyAppearanceRepo pandoraSkyAppearanceRepo;
	
	public void addAppearance(PandoraSkyAppearance pandoraSkyAppearance) {
		pandoraSkyAppearanceRepo.save(pandoraSkyAppearance);
	}
	public List<PandoraSkyAppearance> showAll() {
		return pandoraSkyAppearanceRepo.findAll();
	}
	public void removeAppearanceandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraSkyAppearanceRepo.deletePandoraSkyAppearanceWithFile(Id, fileName); 
			
				String path = uploadDirectory + "/" + fileName;
				System.out.println("Path=" + path);
				File fileToDelete = new File(path);
				fileToDelete.delete();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
