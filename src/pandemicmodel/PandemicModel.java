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
        gui input = new gui();
        ThemePark myPark = new ThemePark(14);
        ParkPop parkPop = new ParkPop(10000,0.01,myPark);
        System.out.println(parkPop.infectedPeople.size());
        //Financials financials = new Financials("disneyFinance.txt",0.5,14);
        for (int i = 0; i < 500; i++) {
            parkPop.update();
            myPark.update();
        }
        for (Attraction a : myPark.layout.attractions) {
            System.out.printf("%-65s" + "%d\n","Infections at " + myPark.layout.attractionsToNames.get(a) + ": " + a.cleanString,a.infectionCounter);
        }
        System.out.println(parkPop.allPeople.get(0).rideCounter);
        System.out.println(parkPop.allPeople.size());
        System.out.println(parkPop.infectedPeople.size());

    }
}
