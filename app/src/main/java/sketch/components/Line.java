package sketch.component;

import java.awt.Graphics2D;

public class Line implements Drawable {
    Coordinate start;
    Coordinate end;

    public Line(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public void draw(Graphics2D g2d) {

    }
}

