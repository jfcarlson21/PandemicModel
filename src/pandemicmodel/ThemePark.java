/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import org.w3c.dom.ls.LSOutput;

/**
 *
 * @author lainiecederholm
 */
public class ThemePark {
    ParkLayout layout;
    int cleaners;
    public ThemePark (String fileName, int workers){
        layout = new ParkLayout(fileName,workers);
        cleaners = workers;
    }
    public void update(){
        for(Attraction a : layout.attractions){
            a.update();


        }
    }
}
