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
public class Line {
    
    static ArrayList<Integer> line = new ArrayList<>();
    static ArrayList<Integer> nextLoc = new ArrayList<>();
    
    public static void lineTest(){
        for(int i=1; i<=10; i++){
            line.add(i);
        }
    }
    
    public static void leaveLine(){
        Line.lineTest();
        if(line.size()>0){
            for(int i=0; i<10; i++){
                nextLoc.add(line.get(0));
                line.remove(0);
                System.out.println(nextLoc);
                System.out.println(line);
            }
            
        }
        else{
            System.out.println("empty line");
        }
    }
    
}
