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
    static ArrayList<Person> healthyPeople = new ArrayList<Person>();
    int totalPopulation;
    public ParkPop(int totalPop, double percentInfected, ThemePark park){
        totalPopulation = totalPop;
        for (int i = 0; i < totalPopulation*percentInfected; i++) {
            Person person = new Person(1, park);
            allPeople.add(person);
            infectedPeople.add(person);
        }
        for (int i = 0; i < totalPopulation*(1-percentInfected); i++) {
            Person person = new Person(0, park);
            allPeople.add(person);
            healthyPeople.add(person);
        }
    }
    public void update(){
        for (Person p : allPeople) {
            if (p.infected>=1 && !infectedPeople.contains(p)){
                healthyPeople.remove(p);
                infectedPeople.add(p);
            }
            p.update();
        }
    }
}
