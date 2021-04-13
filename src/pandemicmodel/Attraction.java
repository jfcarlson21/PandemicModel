package pandemicmodel;

import java.awt.*;
import java.util.ArrayList;

public class Attraction {
    Point location;
    int leaveRate;
    Line line = new Line (leaveRate, this);
    public Attraction(Point loc){
        location = loc;
    }
    public class Ride{
        public int seatsPerCart;
        public int numOfCarts;
        public Ride(int cartNum, int seatsOneCart) {

            seatsPerCart = seatsOneCart;
            numOfCarts = cartNum;
            leaveRate = seatsOneCart;
            ArrayList<Cart> fullRide = new ArrayList<Cart>();
            for (int i = 0; i < numOfCarts; i++) {
                Cart cartE = new Cart(seatsPerCart);
                fullRide.add(cartE);
            }
        }
    }
}
