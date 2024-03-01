package Logic;

public class Player {
    private String name;
    private int score;
    private int level;
    private int gems;
    private double speed;
    private Location Player_location;

    public Player(String name, int score, int level, int gems, double speed, Location Player_location) {
        this.name = name;
        this.score = score;
        this.level = level;
        this.gems = gems;
        this.speed = speed;
        this.Player_location = Player_location;
        System.out.println("Player created");

    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public int getGems() {
        return gems;
    }

    public double getSpeed() {
        return speed;
    }

    public Location getPlayer_location() {
        return Player_location;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public void setGems(int gems) {
        this.gems = gems;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setPlayer_location(Location Player_location) {
        this.Player_location = Player_location;
    }

    public void addScore(int score) {
        this.score += score;
    }


}
