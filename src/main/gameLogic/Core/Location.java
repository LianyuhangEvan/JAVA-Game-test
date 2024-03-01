package Core;

public class Location {
    private double X;
    private double Y;
    private double size;// Size of the volume on the screen

    public Location(double x, double y, double size) {
        X = x;
        Y = y;
        this.size = size;
    }


    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getSize() {
        return size;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
