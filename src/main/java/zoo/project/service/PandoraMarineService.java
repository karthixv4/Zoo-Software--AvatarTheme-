package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraMarine;
import zoo.project.repo.PandoraMarineRepo;

@Service
public class PandoraMarineService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private PandoraMarineRepo pandoraMarineRepo;

	public void addAnimal(PandoraMarine pandoraMarine) {
		pandoraMarineRepo.save(pandoraMarine);
	}

	public void removeAnimal(Long id) {
		pandoraMarineRepo.deleteById(id);
	}

	public List<PandoraMarine> showAll() {
		return pandoraMarineRepo.findAll();
	}

	public Optional<PandoraMarine> ShowById(Long id) {
		return pandoraMarineRepo.findById(id);

	}
	public void removeMarineandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraMarineRepo.deletePandoraMarineWithFile(Id, fileName); 
			
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
