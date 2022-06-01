package zoo.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pass_zoo")
public class PandoraPass {

	@Id
	@Column(name = "SkyAnimals_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String pass_name;

	private Long pass_cost;

	private String perk_one;
	private String perk_two;
	private String perk_three;
	private String perk_four;
	private String perk_five;
	private String perk_six;
	
	private String pass_description;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getPass_name() {
		return pass_name;
	}

	public void setPass_name(String pass_name) {
		this.pass_name = pass_name;
	}

	public Long getPass_cost() {
		return pass_cost;
	}

	public void setPass_cost(Long pass_cost) {
		this.pass_cost = pass_cost;
	}

	public String getPerk_one() {
		return perk_one;
	}

	public void setPerk_one(String perk_one) {
		this.perk_one = perk_one;
	}

	public String getPerk_two() {
		return perk_two;
	}

	public void setPerk_two(String perk_two) {
		this.perk_two = perk_two;
	}

	public String getPerk_three() {
		return perk_three;
	}

	public void setPerk_three(String perk_three) {
		this.perk_three = perk_three;
	}

	public String getPerk_four() {
		return perk_four;
	}

	public void setPerk_four(String perk_four) {
		this.perk_four = perk_four;
	}

	public String getPerk_five() {
		return perk_five;
	}

	public void setPerk_five(String perk_five) {
		this.perk_five = perk_five;
	}

	public String getPerk_six() {
		return perk_six;
	}

	public void setPerk_six(String perk_six) {
		this.perk_six = perk_six;
	}

	public String getPass_description() {
		return pass_description;
	}

	public void setPass_description(String pass_description) {
		this.pass_description = pass_description;
	}

}
