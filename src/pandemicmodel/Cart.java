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
    public Cart(int s){
        seats = s;
        for (int i = 0; i < seats; i++) {
            cartSurfaces.add(new Surfaces("steel"));
        }
    }
    public void addToCart(Person person){
        cartPeople.add(person);
        if (person.infected>0){
            cartSurfaces.get(cartPeople.indexOf(person)).infectSurface();
            System.out.println("surface infected");
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
        }
    }
}
