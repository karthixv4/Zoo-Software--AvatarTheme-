package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraMarineEvents;
import zoo.project.repo.PandoraMarineEventsRepo;

@Service
public class PandoraMarineEventsService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private PandoraMarineEventsRepo pandoraMarineEventsRepo;

	public void addEvents(PandoraMarineEvents pandoraMarineEvents) {
		pandoraMarineEventsRepo.save(pandoraMarineEvents);
	}

	public void removeEvents(Long id) {
		pandoraMarineEventsRepo.deleteById(id);
	}

	public List<PandoraMarineEvents> showAll() {
		return pandoraMarineEventsRepo.findAll();
	}

	public Optional<PandoraMarineEvents> ShowById(Long id) {
		return pandoraMarineEventsRepo.findById(id);

	}
	public void removeMarineEventsandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraMarineEventsRepo.deletePandoraMarineEventsWithFile(Id, fileName); 
			
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

