package pandemicmodel;

import java.awt.*;
import java.util.ArrayList;

public class Attraction {
    String cleanString = "(not sanitized)";
    public int workers = 0;
    public int seatsPerCart;
    public int numOfCarts;
    Point location;
    int leaveRate;
    int timeAtAttraction;
    Line line = new Line (leaveRate, this);
    int infectionCounter = 0;
    boolean isBeingCleaned = false;
    ArrayList<Cart> fullRide = new ArrayList<Cart>();
    public Attraction(Point loc, int timeAtAttraction, int cartNum, int seatsOneCart, boolean isClean) {
        seatsPerCart = seatsOneCart;
        numOfCarts = cartNum;
        leaveRate = seatsOneCart;
        isBeingCleaned = isClean;

        if (isBeingCleaned){
            cleanString = "(sanitized)";

        }
        for (int i = 0; i < numOfCarts; i++) {
            Cart cartE = new Cart(seatsPerCart,this);
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
