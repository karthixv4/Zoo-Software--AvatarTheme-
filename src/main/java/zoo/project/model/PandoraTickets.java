package zoo.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickets_zoo")
public class PandoraTickets {

	 @Id
	 @Column(name="Tickets_Id")
	 @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	 
	 @Column
	private String Name;
	 
	 @Column
	 private Long Phone;
	 
	 @Column
	 private String Pass_Date;
 
	@Column
	private Long Adults;
	 
	 @Column
	private Long Kids;
	 
	 @Column 
	 private String Pass_Name;
	 
	 @Column
	private Long Cost;
	 
	 @Column
     private String users;

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Long getPhone() {
		return Phone;
	}

	public void setPhone(Long phone) {
		Phone = phone;
	}



	public String getPass_Date() {
		return Pass_Date;
	}

	public void setPass_Date(String pass_Date) {
		Pass_Date = pass_Date;
	}

	public Long getAdults() {
		return Adults;
	}

	public void setAdults(Long adults) {
		Adults = adults;
	}

	public Long getKids() {
		return Kids;
	}

	public void setKids(Long kids) {
		Kids = kids;
	}

	public String getPass_Name() {
		return Pass_Name;
	}

	public void setPass_Name(String pass_Name) {
		Pass_Name = pass_Name;
	}

	public Long getCost() {
		return Cost;
	}

	public void setCost(Long cost) {
		Cost = cost;
	}
	
	
}
