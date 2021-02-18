package com.spo.appinit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.spo.business.CapacityOptimizer;
import com.spo.model.Structure;
import com.spo.model.Workforce;

public class AppInit {

	public static void main(String args[]) {
		
		System.out.println("SPO Workforce Optimizer for Partners!!!\n\n");
		
		System.out.println("Enter the size of Structure for Cleaning Partner:");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int structureSize = 0;
        boolean check;
 
        do{
            check = true;
            try{
                try {
					structureSize = Integer.parseInt(in.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
            } catch (NumberFormatException e){
                System.err.println("Input error - Invalid value for an int.");
                System.out.print("Reinsert: ");
                check = false;
            }
        } while (!check);
        
        System.out.println("\nEnter the Array of Rooms:[" +structureSize + "]:");
        int[] roomArray = new int[structureSize];
        for(int i=0; i<roomArray.length; i++)
            do{
                check = true;
                try{
                    try {
    					roomArray[i] = Integer.parseInt(in.readLine());
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
                } catch (NumberFormatException e){
                    System.err.println("Input error - Invalid value for an int.");
                    System.out.print("Reinsert: ");
                    check = false;
                }
            } while (!check);
        
        System.out.println("\nEnter the number of Senior Cleaners:");
        int seniorCleaners = 0;
            do{
                check = true;
                try{
                    try {
                    	seniorCleaners = Integer.parseInt(in.readLine());
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
                } catch (NumberFormatException e){
                    System.err.println("Input error - Invalid value for an int.");
                    System.out.print("Reinsert: ");
                    check = false;
                }
            } while (!check);
        
        System.out.println("\nEnter the number of Junior Cleaners:");
        int juniorCleaners = 0;
            do{
                check = true;
                try{
                    try {
                    	juniorCleaners = Integer.parseInt(in.readLine());
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
                } catch (NumberFormatException e){
                    System.err.println("Input error - Invalid value for an int.");
                    System.out.print("Reinsert: ");
                    check = false;
                }
            } while (!check);
            
        
        System.out.println("\nExecuting Workforce Optimization for the given Structure\n");
        
        Workforce workforce = new Workforce(seniorCleaners, juniorCleaners);
        Structure structure = new Structure();
        structure.setRooms(roomArray);
        structure.setWorkforce(workforce);
        
        CapacityOptimizer capacityOptimizer = new CapacityOptimizer();
        Workforce[] outWorkforce = capacityOptimizer.worfkforceOptimizer(structure);
        for(Workforce work : outWorkforce)
        	System.out.println("\n{Senior:" + work.getSeniorCleaners() + "," + "Junior:" + work.getJuniorCleaners() + "}");
    }
	
}
