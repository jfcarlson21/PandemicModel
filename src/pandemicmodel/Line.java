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
    int length = 0;
    Attraction attraction;
    public Line(int leaveRate, Attraction attraction1){
        attraction = attraction1;
        leaveSize = leaveRate;

    }
    public void leaveLine(){
        length = this.size();
        if(length>leaveSize){
            for(int i=0; i<leaveSize; i++){
                Person person = this.get(0);
                this.remove(0);
                attraction.enter();

            }
            
        }
        else{
            for (int i = 0; i < length; i++) {

            }
        }
    }
    
}
