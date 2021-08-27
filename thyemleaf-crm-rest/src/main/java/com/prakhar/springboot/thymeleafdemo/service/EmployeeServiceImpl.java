package com.prakhar.springboot.thymeleafdemo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.prakhar.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.prakhar.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	// employeeDAOHibernateImpl @Qualifier("employeeDAOJpaImpl")
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	
	//@Transactional
	public List<Employee> findAll() {
		//return employeeRepository.findAll();
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	public Employee findById(int theId) {
		Optional<Employee> result =  employeeRepository.findById(theId);
		
		Employee employee = null;
		if(result.isPresent()) {
			employee =  result.get();
		}else {
			throw new RuntimeException("No Employee found!!! with id = "+theId);
		}
		
		return employee;
	}

	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}

