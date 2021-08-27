package com.prakhar.springboot.thymeleafdemo.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import com.prakhar.springboot.thymeleafdemo.entity.Employee;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code 
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc(); // from Employee order by lastName asc;
}


