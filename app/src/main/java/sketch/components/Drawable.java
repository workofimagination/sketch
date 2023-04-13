package sketch.components;

import java.awt.Graphics2D;

public abstract class Drawable {
    public Coordinate start;
    public Coordinate end;
    public abstract void draw(Graphics2D g2d);
}

