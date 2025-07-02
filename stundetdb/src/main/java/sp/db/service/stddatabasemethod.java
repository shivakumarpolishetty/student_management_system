package sp.db.service;

import java.util.List;
import java.util.Optional;

import sp.db.entity.Student;

public interface stddatabasemethod {

	
	public List<Student> getallstudents();
	
	public  Optional<Student> getstdbyid(int id);
	
	
	public String addstd(Student std);
	
	public void deletestd(int id);

	  public boolean findbyid(int id);
}
