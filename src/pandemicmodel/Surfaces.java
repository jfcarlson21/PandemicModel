/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.util.HashMap;

/**
 *
 * @author lainiecederholm
 */

public class Surfaces {
    double probInfect = 0;
    double INITIALPROB;
    double timeFactor =  1;
    HashMap<String, Double> surfaceInfectionRates = new HashMap<String, Double>();

    public Surfaces(String type) {
        surfaceInfectionRates.put("steel",0.2);
        surfaceInfectionRates.put("wood",0.1);
        surfaceInfectionRates.put("plastic",0.2);
        INITIALPROB = surfaceInfectionRates.get(type);
    }
    
    public void infectSurface(){
        probInfect=timeFactor*INITIALPROB;
    }
    public void clean(){
        probInfect=0;
    }
}
