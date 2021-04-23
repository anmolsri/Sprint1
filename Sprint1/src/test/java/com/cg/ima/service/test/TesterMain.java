package com.cg.ima.service.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.ima.entity.Employee;
import com.cg.ima.entity.User;
import com.cg.ima.exception.InvalidEmployeeException;
import com.cg.ima.service.IEmployeeService;
import com.cg.ima.service.IEmployeeServiceImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import(IEmployeeServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TesterMain {

	@Autowired
	private IEmployeeService eService;
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void testAddEmployee() {
		User user = new User("Anmol","Anmol2099");
		Employee emp = new Employee("Anmol","HR","Bangalore", user);
		em.persist(emp);
		Employee emp1 = eService.addEmployee(emp);
		Assertions.assertEquals(emp1.getEmpName(), emp.getEmpName());
	}

	@Test
	public void testEditEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployee() throws InvalidEmployeeException {
		User user = new User("Anmol","Anmol2099");
		Employee emp = new Employee("Anmol","HR","Bangalore", user);
		em.persist(emp);
		Integer id = emp.getEmpId();
		Employee empFound = eService.getEmployee(id);
		Assertions.assertEquals(empFound.getEmpId(), emp.getEmpId());
	}

	@Test
	public void testUpdateIsAvailable() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateIsFulfilled() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateIsAccepted() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllOffers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllRequirements() {
		fail("Not yet implemented");
	}

}
