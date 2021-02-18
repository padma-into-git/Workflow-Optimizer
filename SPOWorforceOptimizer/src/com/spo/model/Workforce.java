package com.spo.model;

public class Workforce {
	
	private int seniorCleaners;
	private int juniorCleaners;
	
    public Workforce(int seniorStaff, int juniorStaff){
        this.seniorCleaners = seniorStaff;
        this.juniorCleaners = juniorStaff;
    }
    
	public int getSeniorCleaners() {
		return seniorCleaners;
	}
	public void setSeniorCleaners(int seniorCleaners) {
		this.seniorCleaners = seniorCleaners;
	}
	public int getJuniorCleaners() {
		return juniorCleaners;
	}
	public void setJuniorCleaners(int juniorCleaners) {
		this.juniorCleaners = juniorCleaners;
	}
	
}
