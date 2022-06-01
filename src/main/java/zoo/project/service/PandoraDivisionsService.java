package zoo.project.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoo.project.model.PandoraDivisions;
import zoo.project.repo.PandoraDivisionsRepo;
@Service
public class PandoraDivisionsService {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	private PandoraDivisionsRepo pandoraDivisionsRepo;
	
	public void addDivision(PandoraDivisions pandoraDivisions) {
		pandoraDivisionsRepo.save(pandoraDivisions);
	}
	public void removeDivision(Long id) {
		pandoraDivisionsRepo.deleteById(id);
	}
	public void removeDivisionsandFile(Long Id,String fileName) {
		try {
			if (Id != 0 && fileName != null) {
				pandoraDivisionsRepo.deletePandoraDivisionsWithFile(Id, fileName); 
			
				String path = uploadDirectory + "/" + fileName;
				System.out.println("Path=" + path);
				File fileToDelete = new File(path);
				fileToDelete.delete();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public List<PandoraDivisions> showAllDivisions(){
		return pandoraDivisionsRepo.findAll();
	
	}
	public Optional<PandoraDivisions> getDivisionsById(Long id){
		return pandoraDivisionsRepo.findById(id);
	}
}
