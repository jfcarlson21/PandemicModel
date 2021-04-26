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
    int cleanersPerRide;
    int numOfRides;
    public ThemePark (String fileName, int workers){
        layout = new ParkLayout(fileName,workers);
        cleaners = workers;
        numOfRides = layout.attractions.size();
        while(cleaners>0) {
            for (Attraction a : layout.attractions) {
                if (cleaners > 0) {
                    a.workers += 1;
                    cleaners -= 1;
                }
            }
        }
    }
    public void update(){
        for(Attraction a : layout.attractions){
            a.update();

        }
    }
}
