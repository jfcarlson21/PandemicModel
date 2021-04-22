package pandemicmodel;

import java.util.ArrayList;
import java.util.Random;

public class Cart{
    public ArrayList<Surfaces> cartSurfaces = new ArrayList<>();
    public ArrayList<Person> cartPeople = new ArrayList<>();
    int seats;
    double percentThroughAttraction = 0;
    double infect;
    boolean emptyLater = false;
    Attraction attraction;
    public Cart(int s,Attraction a){
        seats = s;
        attraction = a;
        for (int i = 0; i < seats; i++) {
            cartSurfaces.add(new Surfaces("steel"));
        }
    }
    public void addToCart(Person person){
        cartPeople.add(person);
        if (person.infect){
            Surfaces s = cartSurfaces.get(cartPeople.indexOf(person));
            if(attraction.isBeingCleaned) {
                s.cleanFactor=0.05;
                s.infectSurface();
                //System.out.println("surface infected");
            }
            else{
                s.infectSurface();
            }
        }
    }

    public void empty(){
        int numPeopleOnCart = cartPeople.size();
        for (int i = 0; i < numPeopleOnCart; i++) {
            Person p = cartPeople.get(0);
            infect = cartSurfaces.get(cartPeople.indexOf(p)).probInfect;
            if (infect>0){
                p.infected = infect;
            }
            cartPeople.remove(p);
            p.doneWithDestination = true;
            //System.out.println(p.doneWithDestination);
        }
    }
    public void clean(){
        for (Surfaces s : cartSurfaces) {
            s.clean();
        }
    }
}
