package com.spo.appinit;

import com.spo.business.CapacityOptimizer;
import com.spo.model.Structure;
import com.spo.model.Workforce;

public class AppInitSampleTest {
	public static void main(String args[]) {
		
		System.out.println("SPO Workforce Optimizer for Partners!!!\n\n");
		int roomArray[] = new int[]{35,21,17};
		int seniorCleaners = 10;
		int juniorCleaners = 6;

        System.out.println("\nExecuting Workforce Optimization for the given Structure 1\n"
        		+ "{ rooms: [35, 21, 17], senior: 10, junior: 6 }\n");
        
        Workforce workforce = new Workforce(seniorCleaners, juniorCleaners);
        Structure structure = new Structure();
        structure.setRooms(roomArray);
        structure.setWorkforce(workforce);
        
        CapacityOptimizer capacityOptimizer = new CapacityOptimizer();
        Workforce[] outWorkforce = capacityOptimizer.worfkforceOptimizer(structure);
        for(Workforce work : outWorkforce)
        	System.out.println("\n{Senior:" + work.getSeniorCleaners() + "," 
        			+ "Junior:" + work.getJuniorCleaners() + "}");
        
		int roomArray2[] = new int[]{24,28};
		seniorCleaners = 11;
		juniorCleaners = 6;

        System.out.println("\nExecuting Workforce Optimization for the given Structure 2\n"
        		+ "{ rooms: [24, 28], senior: 11, junior: 6 }\n");
        
        workforce = new Workforce(seniorCleaners, juniorCleaners);
        structure = new Structure();
        structure.setRooms(roomArray2);
        structure.setWorkforce(workforce);
        
        capacityOptimizer = new CapacityOptimizer();
        outWorkforce = capacityOptimizer.worfkforceOptimizer(structure);
        for(Workforce work : outWorkforce)
        	System.out.println("\n{Senior:" + work.getSeniorCleaners() + "," 
        			+ "Junior:" + work.getJuniorCleaners() + "}");
    }
}
