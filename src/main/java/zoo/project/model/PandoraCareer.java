package zoo.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "career_zoo")
public class PandoraCareer {
	@Id
	@Column(name = "Career_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column
	private String Name;
	
	@Column
	private String Description;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	
}
