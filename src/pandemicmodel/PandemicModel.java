/*
 * Jake Carlson
 * AT Comp Sci 2020-2021
 * 
 */
package pandemicmodel;
import java.awt.Point;
import java.io.IOException;

/**
 *
 * @author jakecarlson
 */
public class PandemicModel {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        gui GUI = new gui();
        GUI.parkInfoGUI();
        ThemePark myPark = new ThemePark(GUI.layoutFile, GUI.employeeNumber);
        ParkPop parkPop = new ParkPop((int)(GUI.maxCapacity*GUI.percentCapacity), GUI.percentInfected,myPark);
        System.out.println(parkPop.infectedPeople.size());
        Financials financials = new Financials(GUI);
        for (int i = 0; i < 500; i++) {
            parkPop.update();
            myPark.update();
        }

        for (Attraction a : myPark.layout.attractions) {
            GUI.stringList.add(myPark.layout.attractionsToNames.get(a));
            GUI.intList.add(a.infectionCounter);
            GUI.cleanList.add(a.cleanString);
            System.out.printf("%-65s" + "%d\n","Infections at " + myPark.layout.attractionsToNames.get(a) + ": " + a.cleanString,a.infectionCounter);
        }

        GUI.outputGui(parkPop.infectedPeople.size());

        System.out.println(parkPop.allPeople.get(0).rideCounter);
        System.out.println(parkPop.allPeople.size());
        System.out.println();

    }
}
