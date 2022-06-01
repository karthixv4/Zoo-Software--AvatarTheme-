package zoo.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wildEvents_zoo")
public class PandoraWildEvents {

	@Id
	@Column(name = "SkyAnimals_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	private String Event_name;
	
	private String Event_description;
	
	private String Event_time;
	
	private String Event_venue;
	
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

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEvent_name() {
		return Event_name;
	}

	public void setEvent_name(String event_name) {
		Event_name = event_name;
	}

	public String getEvent_description() {
		return Event_description;
	}

	public void setEvent_description(String event_description) {
		Event_description = event_description;
	}

	public String getEvent_time() {
		return Event_time;
	}

	public void setEvent_time(String event_time) {
		Event_time = event_time;
	}

	public String getEvent_venue() {
		return Event_venue;
	}

	public void setEvent_venue(String event_venue) {
		Event_venue = event_venue;
	}
	
	
	
}
