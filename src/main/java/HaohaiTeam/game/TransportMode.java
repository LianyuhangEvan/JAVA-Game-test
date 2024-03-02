package HaohaiTeam.game;

public abstract class TransportMode {
    protected double distance; // 行驶距离

    public TransportMode(double dist) {
        this.distance = dist;
    }

    // 抽象方法，子类需要根据各自交通方式实现
    public abstract double getCarbonFootprint();

    public abstract double getAverageSpeed();

    public double getDistance() {
        return distance;
    }

    // 根据平均速度和距离计算行程所需时间
    public double getDuration() {
        return distance / getAverageSpeed();
    }
}

// Walk类继承TransportMode抽象类并实现相关方法
class Walk extends TransportMode {
    public Walk(double dist) {
        super(dist);
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
}

// Bike类继承TransportMode抽象类并实现相关方法
class Bike extends TransportMode {
    public Bike(double dist) {
        super(dist);
    }

    @Override
    public double getCarbonFootprint() {
        // 假设骑行的碳排放量较低，例如0.05kg CO2/km
        return 0.05 * distance;
    }

    @Override
    public double getAverageSpeed() {
        // 假设平均骑行速度为15km/h
        return 15.0;
    }
}

// 同样的方式，可以继续定义Bus、Luas（轻轨）和Taxi等类，只需要在各自的类中实现getCarbonFootprint和getAverageSpeed方法即可。
