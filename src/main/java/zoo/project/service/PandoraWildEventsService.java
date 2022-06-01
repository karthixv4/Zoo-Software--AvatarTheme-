package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraWildEvents;
import zoo.project.repo.PandoraWildEventsRepo;

@Service
public class PandoraWildEventsService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private PandoraWildEventsRepo pandoraWildEventsRepo;

	public void addEvents(PandoraWildEvents pandoraWildEvents) {
		pandoraWildEventsRepo.save(pandoraWildEvents);
	}

	public void removeEvents(Long id) {
		pandoraWildEventsRepo.deleteById(id);
	}

	public List<PandoraWildEvents> showAll() {
		return pandoraWildEventsRepo.findAll();
	}

	public Optional<PandoraWildEvents> ShowById(Long id) {
		return pandoraWildEventsRepo.findById(id);

	}
	public void removeWildEventsandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraWildEventsRepo.deletePandoraWildEventsWithFile(Id, fileName); 
			
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
