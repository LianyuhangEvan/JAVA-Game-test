package HaohaiTeam.game;

public class Gems {
    private int number; // 宝石数量
    final Location gem_location; // 宝石所在位置，假设Location是一个自定义类，表示经纬度或其他坐标系统
    boolean isTaken; // 标记宝石是否已被玩家获取

    // 构造函数，初始化宝石信息
    public Gems(int num, Location loc) {
        this.number = num;
        this.gem_location = loc;
        this.isTaken = false;
    }

    // 获取宝石数量
    public int getNumber() {
        return number;
    }

    // 设置宝石数量
    public void setNumber(int num) {
        this.number = num;
    }

    // 获取宝石位置
    public Location getLocation() {
        return gem_location;
    }


}

