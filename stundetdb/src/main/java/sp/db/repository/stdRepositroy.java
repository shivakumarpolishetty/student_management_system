package sp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sp.db.entity.Student;

public interface stdRepositroy  extends JpaRepository<Student, Integer>{

	

}
