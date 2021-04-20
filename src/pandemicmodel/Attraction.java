package pandemicmodel;

import java.awt.*;
import java.util.ArrayList;

public class Attraction {
    public int seatsPerCart;
    public int numOfCarts;
    Point location;
    int leaveRate;
    int timeAtAttraction;
    int counter = 0;
    Line line = new Line (leaveRate, this);
    ArrayList<Cart> fullRide = new ArrayList<Cart>();
    public Attraction(Point loc, int timeAtAttraction, int cartNum, int seatsOneCart) {
        seatsPerCart = seatsOneCart;
        numOfCarts = cartNum;
        leaveRate = seatsOneCart;

        for (int i = 0; i < numOfCarts; i++) {
            Cart cartE = new Cart(seatsPerCart);
            fullRide.add(cartE);
            location = loc;
            this.timeAtAttraction = timeAtAttraction;
        }
    }
    public void takeInBatch(Cart cart){
        int length = line.size();
        if(length>=seatsPerCart){
            for(int i=0; i<seatsPerCart; i++){
                Person person = line.get(0);
                line.remove(0);
                cart.addToCart(person);
            }
        }
        else{
            for (int i = 0; i < length; i++) {
                Person person = line.get(0);
                line.remove(0);
                cart.addToCart(person);
            }
        }
        line.trimToSize();
    }
    public void update(){
        for (Cart cart:
             fullRide) {
            if (cart.percentThroughAttraction==0){
                takeInBatch(cart);
                cart.percentThroughAttraction+=0.1;
            }
            else if (cart.percentThroughAttraction>1){
                cart.empty();
                cart.percentThroughAttraction=0;
            }
            else{
                cart.percentThroughAttraction+=.1;
            }
        }

    }
}
