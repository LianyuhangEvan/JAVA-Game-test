package HaohaiTeam.game;

import HaohaiTeam.Ui.Map;
import HaohaiTeam.Ui.GUI;
public class Player {
    private final String name;
    private int score;
    private int level;
    private int gems;
    private double speed;
    private Location Player_location;
    private final Map gameMap; // 添加游戏地图引用

    public Player(String name, int score, int level, int gems, double speed, Location Player_location, Map gameMap) {
        this.name = name;
        this.score = score;
        this.level = level;
        this.gems = gems;
        this.speed = speed;
        this.Player_location = Player_location;
        this.gameMap = gameMap;
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

    public void move(int dx, int dy) {
        // 计算新的位置
        int newX = (int)(Player_location.getX() + dx);
        int newY = (int)(Player_location.getY() + dy);

        // 检查新位置是否有效（在地图范围内且无障碍）
        if (gameMap.isPositionValid(newX, newY)) {
            Player_location.setX(newX);
            Player_location.setY(newY);
        } else {
            System.out.println("Invalid move! The new position is out of bounds or contains an obstacle.");
        }

        GUI gui = getGuiInstance(); // 获取GUI实例的方式取决于您的具体实现
        if (gui != null) {
            gui.updateMap();
        }
    }




}
