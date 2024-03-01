package Logic;

public class Walk implements TransportMode {

    private double distance; // 行走的距离

    public Walk(double dist) {
        this.distance = dist;
    }

    @Override
    public double getCarbonFootprint() {
        // 假设行走的碳排放量较低，例如0.1kg CO2/km
        return 0.1 * distance;
    }

    @Override
    public double getAverageSpeed() {
        // 假设平均步行速度为5km/h
        return 5.0;
    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public double getDuration() {
        return distance / getAverageSpeed();
    }

    // 不需要额外实现getSpeed方法，因为与getAverageSpeed方法功能相同
}

