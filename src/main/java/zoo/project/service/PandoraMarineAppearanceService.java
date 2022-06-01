package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraMarineAppearance;
import zoo.project.repo.PandoraMarineAppearanceRepo;

@Service
public class PandoraMarineAppearanceService {
public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	private PandoraMarineAppearanceRepo pandoraMarineAppearanceRepo;
	
	public void addAppearance(PandoraMarineAppearance pandoraMarineAppearance) {
		pandoraMarineAppearanceRepo.save(pandoraMarineAppearance);
	}

	public void removeAppearance(Long id) {
		pandoraMarineAppearanceRepo.deleteById(id);
	}

	public List<PandoraMarineAppearance> showAll() {
		return pandoraMarineAppearanceRepo.findAll();
	}

	public Optional<PandoraMarineAppearance> ShowById(Long id) {
		return pandoraMarineAppearanceRepo.findById(id);

	}
	public void removeAppearanceandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraMarineAppearanceRepo.deletePandoraMarineAppearanceWithFile(Id, fileName); 
			
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
