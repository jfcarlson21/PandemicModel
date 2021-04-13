/*
 * Lainie Cederholm
 * AT Computer Science 2020-2021
 * 
 */
package pandemicmodel;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author lainiecederholm
 */
public class Ride extends Attraction{
    public int seatsPerCart;
    public int numOfCarts;
    public Ride(Point loc, int cartNum, int seatsOneCart) {
        super(loc);
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
