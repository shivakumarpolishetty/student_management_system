package sp.db.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sp.db.entity.Student;
import sp.db.repository.stdRepositroy;


@Service
public   class stdService implements stddatabasemethod{

	
	@Autowired
	private stdRepositroy stdrepo;


	@Override
	public List<Student> getallstudents() {
		
		return stdrepo.findAll();		
	}
	@Override
	public String addstd(Student std) {
		
		stdrepo.save(std);
		return "successfully added";
	}
	@Override
	public Optional<Student> getstdbyid(int id) {
	 
	  return stdrepo.findById(id);
	
	
}
	@Override
	public void deletestd(int id) {

      		stdrepo.deleteById(id);
      		
      		

		
	}
	@Override
	public boolean findbyid(int id) {
		
		 return stdrepo.existsById(id);
		
	}

	
	
}