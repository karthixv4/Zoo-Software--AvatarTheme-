package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraWild;
import zoo.project.repo.PandoraWildRepo;

@Service
public class PandoraWildService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private PandoraWildRepo pandoraWildRepo;

	public void addAnimal(PandoraWild pandoraWild) {
		pandoraWildRepo.save(pandoraWild);
	}

	public void removeAnimal(Long id) {
		pandoraWildRepo.deleteById(id);
	}

	public List<PandoraWild> showAll() {
		return pandoraWildRepo.findAll();
	}

	public Optional<PandoraWild> ShowById(Long id) {
		return pandoraWildRepo.findById(id);

	}
	public void removeWildandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraWildRepo.deletePandoraWildWithFile(Id, fileName); 
			
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
