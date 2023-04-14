package sketch.components;

public class Coordinate {
    public double x;
    public double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X: " + this.x + " Y: " + this.y;
    }

}
