package sketch.components;

import java.awt.Graphics2D;

public interface Drawable {
    public Coordinate getStart();
    public Coordinate getEnd();
    public abstract void draw(Graphics2D g2d);
}

