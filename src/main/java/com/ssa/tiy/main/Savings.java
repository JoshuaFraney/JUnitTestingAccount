package com.ssa.tiy.main;

import java.text.DecimalFormat;

public class Savings extends Account {
	
	private DecimalFormat df = new DecimalFormat("####0.00");
	
	private double interestRate;
	int months;
	private double monthlyRate;
	//private double minBalance;
	//private double totalInterest;
	
	public Savings() {
		this.interestRate = 0.015;
	}
	public Savings(String description) {
		super(description);
		this.interestRate = 0.015;
	}
	public Savings(int id, String description) {
		super(id, description);
		this.interestRate = 0.015;
	}
	public String print() {
		return super.print() + " including a " + getInterestRate() + " interest rate";
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void calcDepositInterest(int months) {
		monthlyRate = (this.interestRate / 12);
		double newRate = (monthlyRate * months);
		deposit(newRate * getBalance());
		}
	
	/*public double getTotalInterest() {
		return totalInterest;
	}
	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}
		
	public double getMinBalance() {
		if(balance < minBalance){
			setInterestRate(0);
			return balance;
		} else {
		return minBalance;
	}
		}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}*/
	
	
}
