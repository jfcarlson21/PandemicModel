package pandemicmodel;

import java.util.ArrayList;

public class Cart{
    public ArrayList<Surfaces> cartSurfaces = new ArrayList<>();
    public ArrayList<Person> cartPeople = new ArrayList<>();
    int seats;
    public Cart(int s){
        seats = s;
        for (int i = 0; i < seats; i++) {
            cartSurfaces.add(new Surfaces("metal"));
        }
    }
    public void addToCart(Person person){
        cartPeople.add(person);
        if (person.infected){
            cartSurfaces.get(cartPeople.indexOf(person)).infectSurface();
        }
    }
}
