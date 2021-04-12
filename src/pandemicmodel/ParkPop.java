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
public class ParkPop {
    ArrayList<Person> allPeople = new ArrayList<Person>();
    ArrayList<Person> infectedPeople = new ArrayList<Person>();
    ArrayList<Person> healthyPeople = new ArrayList<Person>();
    int totalPopulation;
    public void ParkPop(int totalPop, double percentInfected, ThemePark park){
        totalPopulation = totalPop;
        for (int i = 0; i < totalPopulation*percentInfected; i++) {
            Person person = new Person(true, park);
            allPeople.add(person);
            infectedPeople.add(person);
        }
        for (int i = 0; i < totalPopulation*(1-percentInfected); i++) {
            Person person = new Person(true, park);
            allPeople.add(person);
            healthyPeople.add(person);
        }
    }

}
