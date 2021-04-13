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
}
