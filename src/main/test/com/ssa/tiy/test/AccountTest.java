package com.ssa.tiy.test;

import static org.junit.Assert.*;

import com.ssa.tiy.main.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	@Before
	public void setup(){
		System.out.println("I luv JUnit, Do you?");
		
	}
	Account myAccount1 = new Account();
	Savings mySavings1 = new Savings();
	Checking myChecking1 = new Checking();
	
	@Test
	public void testAccount() {
		Account newAcct = new Account();
		newAcct.setBalance(500);
		assertEquals(500, newAcct.getBalance(), 0);
		assertEquals(600, newAcct.deposit(100), 0);
		assertEquals(900, newAcct.deposit(300), 0);
		assertEquals(900, newAcct.deposit(-100),0);
		assertEquals(300, newAcct.withdraw(600),0 );
		assertEquals(150, newAcct.withdraw(150), 0);
		assertEquals(150, newAcct.withdraw(300),0);
		newAcct.setId(101);
		assertEquals(101, newAcct.getId());
		assertEquals("Account 101 has a current balance of $150.00", newAcct.print());
		Account newAct = new Account("My Account");
		assertEquals("My Account", newAct.getDescription());
		assertEquals(0, newAct.getBalance(),0);
		newAct.setBalance(5000);
		assertEquals(5000, newAct.getBalance(),0);
		Account myAcct = new Account(621, "Play Money");
		assertEquals(621, myAcct.getId());
		assertEquals("Play Money", myAcct.getDescription());
		assertEquals("Account 621 has a current balance of $0.00", myAcct.print());
		assertEquals(300, myAcct.deposit(300), 0);
		myAcct.transferFrom(newAcct, 150);
		assertEquals(450, myAcct.getBalance(),0);
		assertEquals(0, newAcct.getBalance(),0);
		myAcct.setNewId(4562);
		assertEquals(4562, myAcct.getNewId(),0);
		myAccount1.setBalance(1000);
		assertEquals(1000, myAccount1.getBalance(),0);
				
	}
	public void testSavings(){
		Savings mySavings = new Savings();
		mySavings.setBalance(100);
		assertEquals(100, mySavings.getBalance(),0);
		assertEquals(750, mySavings.deposit(650),0);
		assertEquals(500, mySavings.withdraw(250),0);
		mySavings.setInterestRate(.015);
		assertEquals(0.015, mySavings.getInterestRate(),0);
		mySavings.calcDepositInterest(4);  //interest should be 2.50 making the balance 502.50
		assertEquals(502.50, mySavings.getBalance(),0);
		mySavings.setBalance(1000);
		mySavings.calcDepositInterest(8);
		assertEquals(1010, mySavings.getBalance(),0);
		Savings newSavings = new Savings("Shmee Test");
		newSavings.setId(501);
		assertEquals(501, newSavings.getId(),0);
		assertEquals("Shmee Test", newSavings.getDescription(),0);
		newSavings.setBalance(500);
		assertEquals(500, newSavings.getBalance(),0);
		newSavings.calcDepositInterest(16);
		assertEquals(510, newSavings.getBalance(),0);
		newSavings.transferFrom(mySavings, 200);
		assertEquals(710, mySavings.getBalance(),0);
		assertEquals(810, newSavings.getBalance(),0);
		newSavings.setId(201);
		newSavings.setInterestRate(.015);
		assertEquals("Account 201 has a current balance of $810.00 including a 0.015 interest rate", newSavings.print());
		Savings personalSavings = new Savings(999, "My personal savings account");
		assertEquals(999, personalSavings.getId(),0);
		assertEquals("My personal savings account", personalSavings.getDescription(),0);
		assertEquals(0, personalSavings.getBalance(),0);
		personalSavings.setInterestRate(.05);
		assertEquals(.05, personalSavings.getInterestRate(),0);
		personalSavings.setBalance(6666);
		assertEquals(6666, personalSavings.getBalance(),0);
		personalSavings.calcDepositInterest(30);
		assertEquals(6680, personalSavings.getBalance(),0);
		mySavings1.setBalance(3000);
		assertEquals(3000, mySavings1.getBalance(),0);
		
				
	}
	public void testChecking() {
		Checking newChecking = new Checking();
		assertEquals(0, newChecking.getBalance(),0);
		newChecking.setBalance(120);
		assertEquals(120, newChecking.getBalance(),0);
		newChecking.setLastCheckNbr(100);
		assertEquals(100, newChecking.getLastCheckNbr(),0);
		Checking myChecking = new Checking("My checking account");
		assertEquals(0, myChecking.getBalance(),0);
		assertEquals("My checking account", myChecking.getDescription(),0);
		myChecking.setBalance(900);
		assertEquals(900, myChecking.getBalance(),0);
		assertEquals(101, myChecking.getLastCheckNbr(),0);
		newChecking.transferFrom(myChecking, 80);
		assertEquals(200, newChecking.getBalance(),0);
		assertEquals(820, myChecking.getBalance(),0);
		Checking personalChecking = new Checking(1096, "Personal checking");
		assertEquals(0, personalChecking.getBalance(),0);
		assertEquals("Personal checking", personalChecking.getDescription(),0);
		personalChecking.setDescription("bwagagaga");
		assertEquals("bwagagaga", personalChecking.getDescription(),0);
		personalChecking.setBalance(70);
		assertEquals(70, personalChecking.getBalance(),0);
		assertEquals(102, personalChecking.getLastCheckNbr(),0);
		personalChecking.setLastCheckNbr(128);
		assertEquals(128, personalChecking.getLastCheckNbr(),0);
		myChecking1.setBalance(1500);
		assertEquals(1500, myChecking1.getBalance(),0);
		assertEquals(3000, mySavings1.getBalance(),0);
		assertEquals(1000, myAccount1.getBalance(),0);
		mySavings1.transferFrom(myChecking1, 500);
		assertEquals(3500, mySavings1.getBalance(),0);
		assertEquals(1000, myChecking1.getBalance(),0);
		mySavings1.transferFrom(myAccount1, 800);
		assertEquals(4300, mySavings1.getBalance(),0);
		assertEquals(200, myAccount1.getBalance(),0);
	}

}
