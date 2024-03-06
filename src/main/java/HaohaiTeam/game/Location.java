package HaohaiTeam.game;

public class Location {
    private double X;
    private double Y;
    private double size; // Size of the volume on the screen
    private String name; // New attribute: Name of the location

    public Location(double x, double y, double size, String name) {
        X = x;
        Y = y;
        this.size = size;
        this.name = name;
    }



    // Existing getters and setters for X, Y, and size

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

    // New getter and setter for the "name" attribute

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
