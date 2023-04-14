package sketch.components;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Line extends Drawable {
    Coordinate start;
    Coordinate end;

    public Line(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }

    public Line(double startX, double startY, double endX, double endY) {
        this.start = new Coordinate(startX, startY);
        this.end = new Coordinate(endX, endY);
    }
    
    @Override
    public void draw(Graphics2D g2d) {
        g2d.draw(new Line2D.Double(this.start.x, this.start.y, this.end.x, this.end.y));
    }
}

