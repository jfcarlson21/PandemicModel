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
public class Ride extends Attraction{
    int seatsPerCart;
    int numOfCarts;
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
