package com.cg.ima.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ima.entity.Employee;
import com.cg.ima.entity.Offer;
import com.cg.ima.entity.Proposal;
import com.cg.ima.entity.Requirement;
import com.cg.ima.exception.InvalidEmployeeException;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
//	Employee saveEmployee(Employee emp);
	
//	@Modifying
//	@Query("update emp_test e set e.DEPT_NAME=:deptName")
//	Employee updateEmployee(@Param("deptName") Employee emp);
	
//	Employee fetchEmployee(int empId);
	
	@Query(value = "select * FROM Offer WHERE is_Available = 1", nativeQuery = true)
	Offer statusUpdate(Offer offer);
	
	@Query(value ="select * FROM Requirement WHERE is_Fulfilled = 1",nativeQuery = true )
	Requirement statusUpdate(Requirement req);

	@Query(value="select * FROM Proposal WHERE is_Accepted = 1",nativeQuery = true)
	Proposal statusUpdate(Proposal prop);

//	@Query("select Offer.offerId as offerId, Offer.availableUpto as availableUpto, Offer.isAvailable as isAvailable, Proposal.empId as empId from Proposal Proposal, Offer OFFER where OFFER.offerId=Proposal.offerId and Proposal.empId =: empId") 
//	List<Offer> fetchAllOffers(@Param("empId") int empId) throws InvalidEmployeeException;
	
//	@Query("select Requirement.reqId as reqId, Requirement.fulfilledOn as fulfilledOn, Requirement.isFulfilled as isFulfilled, Proposal.empId as empId from Proposal Proposal, Requirement Requirement where Requirement.reqId=Proposal.reqId and Proposal.empId =:empId")
//	List<Requirement> fetchAllRequirements(@Param("empId") int empId) throws InvalidEmployeeException;
}
