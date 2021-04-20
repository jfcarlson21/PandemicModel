/*
 * Jake Carlson
 * AT Comp Sci 2020-2021
 * 
 */
package pandemicmodel;
import java.awt.Point;

/**
 *
 * @author jakecarlson
 */
public class PandemicModel {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThemePark myPark = new ThemePark();
        ParkPop parkPop = new ParkPop(1,0.1,myPark);
        for (int i = 0; i < 100000; i++) {
            parkPop.update();
            myPark.update();
        }

    }
}
