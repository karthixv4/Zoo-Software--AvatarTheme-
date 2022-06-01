package zoo.project.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "marineAnimals_zoo")
public class PandoraMarine {
	

		@Id
		@Column(name = "MarineAnimals_Id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long Id;

		
		
		@Column
		private String AnimalName;

		@Column(name = "file_name")
		private String fileName;

		@Column(name = "file_path")
		private String filePath;

		@Column(name = "file_type")
		private String fileType;

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}


		public String getAnimalName() {
			return AnimalName;
		}

		public void setAnimalName(String animalName) {
			AnimalName = animalName;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public String getFileType() {
			return fileType;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

	

}
