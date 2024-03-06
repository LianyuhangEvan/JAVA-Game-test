package HaohaiTeam.Ui;

import HaohaiTeam.game.Player;

public class Map {
    private final int width; // 地图宽度
    private final int height; // 地图高度
    private final int tileSize; // 单元格大小
    private final int[][] mapData; // 地图数据（二维数组）
    private MapPanel mapPanel;

    public enum TileType {
        EMPTY_SPACE(true),
        WALL(false),
        ROAD(true),
        START_POINT(true),
        END_POINT(true);

        private final boolean passable;

        TileType(boolean passable) {
            this.passable = passable;
        }

        public boolean isPassable() {
            return passable;
        }
    }

    public Map(int width, int height, int tileSize, MapPanel mapPanel) {
        this.width = width;
        this.height = height;
        this.tileSize = tileSize;
        // 初始化地图数据为EMPTY_SPACE
        mapData = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                mapData[row][col] = TileType.EMPTY_SPACE.ordinal();
            }
        }
    }

    // 获取地图的宽度
    public int getWidth() {
        return width;
    }

    // 获取地图的高度
    public int getHeight() {
        return height;
    }

    // 获取单元格的大小
    public int getTileSize() {
        return tileSize;
    }

    // 设置地图上指定位置的地形类型
    public void setTileType(int x, int y, TileType tileType) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            mapData[y][x] = tileType.ordinal();
        }
    }

    // 获取地图上指定位置的地形类型
    public TileType getTileType(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return TileType.values()[mapData[y][x]];
        }
        return null; // 或者抛出异常，取决于您的设计需求
    }

    public boolean isPositionValid(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight()
                && // 这里根据实际地图数据结构判断当前位置是否为空地或可通行区域
                getTileType(x, y).isPassable();
    }

    public void playerMoved(Player player) {
        mapPanel.refreshPlayerLocation(player.getPlayer_location()); // 假设MapPanel有个刷新玩家位置的方法
    }
}
