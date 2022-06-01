package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraSkyEvents;
import zoo.project.repo.PandoraSkyEventsRepo;

@Service
public class PandoraSkyEventsService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private PandoraSkyEventsRepo pandoraSkyEventsRepo;

	public void addEvents(PandoraSkyEvents pandoraSkyEvents) {
		pandoraSkyEventsRepo.save(pandoraSkyEvents);
	}

	public void removeEvents(Long id) {
		pandoraSkyEventsRepo.deleteById(id);
	}

	public List<PandoraSkyEvents> showAll() {
		return pandoraSkyEventsRepo.findAll();
	}

	public Optional<PandoraSkyEvents> ShowById(Long id) {
		return pandoraSkyEventsRepo.findById(id);

	}
	public void removeSkyEventsandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraSkyEventsRepo.deletePandoraSkyEventsWithFile(Id, fileName); 
			
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
