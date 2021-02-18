package com.spo.business;

import java.util.ArrayList;

import com.spo.model.Structure;
import com.spo.model.Workforce;

public class CapacityOptimizer {
	
	public Workforce[] worfkforceOptimizer(Structure struct){
		
        ArrayList<Workforce> workforce = new ArrayList<Workforce>();
        
        for(int roomCount : struct.getRooms()){
            workforce.add(optimiseForBuilding(roomCount, struct.getWorkforce().getSeniorCleaners(),
            		struct.getWorkforce().getJuniorCleaners()));
        }

        return workforce.toArray(new Workforce[workforce.size()]);
		
	}
	
    private Workforce optimiseForBuilding(int buildingSize, int seniorCapacity, int juniorCapacity){

        int startSeniors =  (int)Math.ceil((double)buildingSize/(double)seniorCapacity);
        int startJuniors = 0; 
        
        int minOffset = GreatestCommonDivisor(seniorCapacity,juniorCapacity);
        int minStepSize = Math.min(seniorCapacity, juniorCapacity);
        
        int[] result = exploreOptimalWorkforce(Integer.MAX_VALUE,buildingSize,minOffset,minStepSize,seniorCapacity,juniorCapacity,startSeniors,startSeniors,startJuniors,startJuniors);
        
        return new Workforce(result[0],result[1]);
    }
	

    private int GreatestCommonDivisor(int a, int b) {
    	
        if (b==0){
            return a;
        }
        
        return GreatestCommonDivisor(b,a%b);
    }
    
    private int[] exploreOptimalWorkforce(int priorDistance, int buildingSize, int minInterval, int minStep, int seniorCapacity, int juniorCapacity, int priorSeniors, int currSeniors, int priorJuniors, int currJuniors){
        
        int currentStaffCapacity = (seniorCapacity * currSeniors) + (juniorCapacity * currJuniors);
        int distance = Math.abs(currentStaffCapacity-buildingSize);
        
        if(distance <= minInterval && currentStaffCapacity >= buildingSize){
            return new int[]{currSeniors,currJuniors}; 
        }
        
        if(distance > minStep && currentStaffCapacity < buildingSize){
            return new int[]{priorSeniors,priorJuniors};
        }
                
        if(currentStaffCapacity>buildingSize && currSeniors > 1){
            return exploreOptimalWorkforce(distance,buildingSize, minInterval, minStep, seniorCapacity, juniorCapacity, currSeniors, currSeniors-1, currJuniors, currJuniors);
        }
        
        if(currentStaffCapacity<buildingSize){
            return exploreOptimalWorkforce(priorDistance,buildingSize, minInterval, minStep, seniorCapacity, juniorCapacity, currSeniors, currSeniors, currJuniors, currJuniors+1);
        }
        
        return new int[]{currSeniors,currJuniors};
    }
}
