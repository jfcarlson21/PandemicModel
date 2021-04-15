package pandemicmodel;

import java.awt.*;

public class Attraction {
    Point location;
    int leaveRate;
    final int timeAtAttraction;
    Line line = new Line (leaveRate, this);

    public Attraction(Point loc, int timeAtAttraction){
        location = loc;
        this.timeAtAttraction = timeAtAttraction;
    }
    public void takeIn(Person person){

    }
}
