package com.ssa.tiy.main;

import java.text.DecimalFormat;

	// A bank account
	public class Account {
		
		//format the decimals to 2 decimal places
		DecimalFormat df = new DecimalFormat("####0.00");
		
	  private int Id; // unique identifier for the account
	  private String description; // a user defined name for the account
	  double balance; // the amount in the account.
	  private static int newId = 100;
	  
	  	//constructor for creating a new account 3 ways
		public Account() {
			//System.out.println("A new account has been created with Account Id: " + newId);
		    //System.out.println("***********************************************************************************************");
			Id = newId;
			newId++;
		}
		public Account(String description) {
			//System.out.println("A new account has been created with Account Id: " + newId);
		    //System.out.println("***********************************************************************************************");
			setDescription(description);
			Id = newId;
			newId++;
		}
		public Account(int Id, String description) {
			//System.out.println("A new account has been created with Account Id: " + Id);
		    //System.out.println("***********************************************************************************************");
			setId(Id);
			setDescription(description);
			newId++;
			}
		
		public int getNewId() {
			return newId;
		}
		public void setNewId(int newId) {
			Account.newId = newId;
		}
		//getter and setter for description
		public String getDescription() {
			    return this.description;
			  }
		public void setDescription(String description) {
			    this.description = description;
			  }
		//getter and setter for Id
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		//getter and setter for balance
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
	  // returns the account info as a string
		public String print()  {
			  return "Account " + Id +  " has a current balance of $" + df.format(balance); 
			 // System.out.println("Account ID " + Id + "has a current balance of $" + df.format(balance));
	  }
	

	// deposit into the account
	 public double deposit(double amount) {
		if (amount < 0) {
			System.out.println("Error! Unable to process the requested deposit");
		}
		else {
	    balance += amount;
	     }
		return balance;
	  }
	  // withdraw from the account, but cannot go negative
	  public double withdraw(double amount) {
	    if(amount > balance) {
	      System.out.println("Insufficient funds! Unable to complete the requested withdrawal.");
	    } else if(amount < 0)
			System.out.println("Error! Unable to process the requested withdraw");
	    else {
	      balance -= amount;
	    }
	    return balance;
	}
	  
	  public void transferFrom(Account bank, double x) {
		    if (x <= this.balance) {
		        bank.withdraw(x);
		        deposit(x);
		        //System.out.println("\nTransfer successful. Transfered: $" + df.format(x));
			    //System.out.println("***********************************************************************************************");
		    } else { 
		        //System.out.println("\nTransfer failed, Insufficient Balance!");
			    //System.out.println("***********************************************************************************************");
		    }
		}
	}