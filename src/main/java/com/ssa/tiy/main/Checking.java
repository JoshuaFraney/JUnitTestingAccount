package com.ssa.tiy.main;

public class Checking extends Account{

	private static int lastCheckNbr = 100;
	

	public Checking(){
		lastCheckNbr++;
		}
	public  Checking(String description) {
		super(description);
		lastCheckNbr++;
		}
	public Checking(int id, String description){
		super(id, description);
		lastCheckNbr++;
		}
	public int getLastCheckNbr() {
		return lastCheckNbr;
	}
	public void setLastCheckNbr(int lastCheckNbr) {
		Checking.lastCheckNbr = lastCheckNbr;
	}
	
	}

