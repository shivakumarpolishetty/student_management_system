package sp.db.entity;

import org.hibernate.annotations.IdGeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
	
	
	@Id
	private Integer id;
	@Column
	private String name;
	@Column
	private Integer score;
	@Column
	private String dep;
	@Column
	private String state;
	
	public Student()
	{
		
	}
	
	public Student(Integer id, String name, Integer score, String dep, String state) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.dep = dep;
		this.state = state;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + ", dep=" + dep + ", state=" + state + "]";
	}
	
	
	
	
	
	
	

}
