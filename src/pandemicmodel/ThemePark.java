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
    ParkLayout layout = new ParkLayout("disneyLayout.txt");
    public void update(){
        for(Attraction a : layout.attractions){
            System.out.println("\n\nRide--> "+layout.attractionsToNames.get(a));
            a.update();
        }
    }
}
