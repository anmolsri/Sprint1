package com.cg.ima.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "proposal")
public class Proposal {
	@Id
	@SequenceGenerator(name="prop", initialValue = 1001, allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "prop")
	private int propId;
	private String proposal;
	private double amount;
	private LocalDate proposalDate;
	private boolean isAccepted;
	
	private LocalDate acceptedOn;
	@ManyToOne(cascade = CascadeType.ALL)	
	@JoinColumn
	private Employee emp;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JoinColumn(name = "resid")
	private Resource resource;
	public int getPropId() {
		return propId;
	}
	public void setPropId(int propId) {
		this.propId = propId;
	}
	public String getProposal() {
		return proposal;
	}
	public void setProposal(String proposal) {
		this.proposal = proposal;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getProposalDate() {
		return proposalDate;
	}
	public void setProposalDate(LocalDate proposalDate) {
		this.proposalDate = proposalDate;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public LocalDate getAcceptedOn() {
		return acceptedOn;
	}
	public void setAcceptedOn(LocalDate acceptedOn) {
		this.acceptedOn = acceptedOn;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public Proposal(String proposal, double amount, LocalDate proposalDate, boolean isAccepted, LocalDate acceptedOn,
			 Resource resource) {
		
		this.proposal = proposal;
		this.amount = amount;
		this.proposalDate = proposalDate;
		this.isAccepted = isAccepted;
		this.acceptedOn = acceptedOn;
		this.emp = resource.getEmp();
		this.resource = resource;
	}
	@Override
	public String toString() {
		return "Proposal [propId=" + propId + ", proposal=" + proposal + ", amount=" + amount + ", proposalDate="
				+ proposalDate + ", isAccepted=" + isAccepted + ", acceptedOn=" + acceptedOn + ", emp=" + emp
				+ ", resource=" + resource + "]";
	}
	public Proposal() {
		
	}
	
	
}
