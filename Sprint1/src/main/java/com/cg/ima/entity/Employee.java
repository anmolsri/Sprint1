package com.cg.ima.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "emp_test")
public class Employee {
	@Id
	@SequenceGenerator(name="emp22", initialValue = 50001, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "emp22")
	private int empId;
	@NotNull @Size(min=2, max=20)
	private String empName;
	@NotNull @Size(min=2, max=20)
	private String deptName;
	@NotNull @Size(min=2, max=20)
	private String location;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	public int getEmpId() {
		return empId;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", location=" + location
				+ "]";
	}
	public Employee(String empName, String deptName, String location,User user) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.location = location;
		this.user=user;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
