/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.util.ArrayList;

/**
 *
 * @author lainiecederholm
 */
public class Line extends java.util.ArrayList<Person>{
    int leaveSize;
    public Line(int leaveRate){
        leaveSize = leaveRate;
    }

    

    
    public void leaveLine(){
        if(this.size()>0){
            for(int i=0; i<10; i++){
                nextLoc.add(this.get(0));
                this.remove(0);
                System.out.println(nextLoc);
                System.out.println(this);
            }
            
        }
        else{
            System.out.println("empty line");
        }
    }
    
}
