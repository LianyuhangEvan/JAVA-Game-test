package HaohaiTeam.Ui;

import HaohaiTeam.game.Location;
import HaohaiTeam.Ui.Map;
import HaohaiTeam.game.Player;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    private final Map gameMap;
    private final Player player;

    public MapPanel(Map gameMap, Player player) {
        this.gameMap = gameMap;
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 绘制地图背景和网格线
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        for (int i = 0; i <= gameMap.getWidth(); i++) {
            g.drawLine(i * gameMap.getTileSize(), 0, i * gameMap.getTileSize(), getHeight());
        }
        for (int i = 0; i <= gameMap.getHeight(); i++) {
            g.drawLine(0, i * gameMap.getTileSize(), getWidth(), i * gameMap.getTileSize());
        }

        // 绘制玩家当前位置
        if (player != null) {
            int x = (int) (player.getPlayer_location().getX() * gameMap.getTileSize());
            int y = (int) (player.getPlayer_location().getY() * gameMap.getTileSize());
            g.setColor(Color.BLUE);
            g.fillOval(x, y, gameMap.getTileSize(), gameMap.getTileSize());
        }
    }

    // 假设您需要这个方法来更新玩家位置
    public void refreshPlayerLocation(Location newLocation) {
        // 更新玩家位置的内部状态（如果需要）
        // ...

        repaint(); // 重绘整个面板以显示新的玩家位置
    }
}