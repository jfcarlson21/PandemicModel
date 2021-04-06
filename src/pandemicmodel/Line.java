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
    

    
    public void lineTest(){
        for(int i=1; i<=10; i++){
            this.add(i);
        }
    }
    
    public void leaveLine(){
        Line.lineTest();
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
