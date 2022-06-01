package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import zoo.project.model.PandoraUnitedAppearance;
import zoo.project.repo.PandoraUnitedAppearanceRepo;
@Service
public class PandoraUnitedAppearanceService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	private PandoraUnitedAppearanceRepo pandoraUnitedAppearanceRepo;
	
	public void addAppearance(PandoraUnitedAppearance pandoraUnitedAppearance) {
		pandoraUnitedAppearanceRepo.save(pandoraUnitedAppearance);
	}

	public void removeAppearance(Long id) {
		pandoraUnitedAppearanceRepo.deleteById(id);
	}

	public List<PandoraUnitedAppearance> showAll() {
		return pandoraUnitedAppearanceRepo.findAll();
	}

	public Optional<PandoraUnitedAppearance> ShowById(Long id) {
		return pandoraUnitedAppearanceRepo.findById(id);

	}
	public void removeAppearanceandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraUnitedAppearanceRepo.deletePandoraUnitedAppearanceWithFile(Id, fileName); 
			
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
