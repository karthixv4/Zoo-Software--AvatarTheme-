package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraSky;
import zoo.project.repo.PandoraSkyRepo;

@Service
public class PandoraSkyService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private PandoraSkyRepo pandoraSkyRepo;

	public void addAnimal(PandoraSky pandoraSky) {
		pandoraSkyRepo.save(pandoraSky);
	}

	public void removeAnimal(Long id) {
		pandoraSkyRepo.deleteById(id);
	}

	public List<PandoraSky> showAll() {
		return pandoraSkyRepo.findAll();
	}

	public Optional<PandoraSky> ShowById(Long id) {
		return pandoraSkyRepo.findById(id);

	}
	public void removeSkyandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraSkyRepo.deletePandoraSkyWithFile(Id, fileName); 
			
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
