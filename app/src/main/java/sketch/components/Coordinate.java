package sketch.components;

public class Coordinate {
    public float x;
    public float y;

    public Coordinate(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(double x, double y) {
        this.x = (float) x;
        this.y = (float) y;
    }
    @Override
    public String toString() {
        return "X: " + this.x + " Y: " + this.y;
    }

}
