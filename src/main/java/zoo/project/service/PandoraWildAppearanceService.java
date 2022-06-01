package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import zoo.project.model.PandoraWildAppearance;
import zoo.project.repo.PandoraWildAppearanceRepo;
@Service
public class PandoraWildAppearanceService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	private PandoraWildAppearanceRepo pandoraWildAppearanceRepo;
	
	public void addAppearance(PandoraWildAppearance pandoraWildAppearance) {
		pandoraWildAppearanceRepo.save(pandoraWildAppearance);
	}

	public void removeAppearance(Long id) {
		pandoraWildAppearanceRepo.deleteById(id);
	}

	public List<PandoraWildAppearance> showAll() {
		return pandoraWildAppearanceRepo.findAll();
	}

	public Optional<PandoraWildAppearance> ShowById(Long id) {
		return pandoraWildAppearanceRepo.findById(id);

	}
	public void removeAppearanceandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraWildAppearanceRepo.deletePandoraWildAppearanceWithFile(Id, fileName); 
			
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
