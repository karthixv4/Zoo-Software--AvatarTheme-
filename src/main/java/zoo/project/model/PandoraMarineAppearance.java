package zoo.project.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "marineAppearance_zoo")
public class PandoraMarineAppearance {

		@Id
		@Column(name = "MarineAppearance_Id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long Id;

		@Column
		private String HeadingOne;

		@Column
		private String HeadingTwo;
		
		@Column(name = "file_name")
		private String fileName;

		@Column(name = "file_path")
		private String filePath;

		@Column(name = "file_type")
		private String fileType;

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

		public String getHeadingOne() {
			return HeadingOne;
		}

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public void setHeadingOne(String headingOne) {
			HeadingOne = headingOne;
		}

		public String getHeadingTwo() {
			return HeadingTwo;
		}

		public void setHeadingTwo(String headingTwo) {
			HeadingTwo = headingTwo;
		}

	

}
