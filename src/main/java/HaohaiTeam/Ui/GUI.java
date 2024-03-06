package HaohaiTeam.Ui;

import HaohaiTeam.game.Location;
import HaohaiTeam.Ui.Map;
import HaohaiTeam.game.Player;
import HaohaiTeam.game.PlayerListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements PlayerListener {
    private Map gameMap; // 游戏地图
    private Player player; // 玩家对象
    private MapPanel mapPanel; // 地图面板

    public GUI() {
        setTitle("Shared-Mobility Adventure Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGame();
        initUI();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });
    }

    private void initGame() {
        gameMap = new Map(10, 10, 50, mapPanel); // 示例尺寸
        player = new Player("Player1", 0, 0, 0, 0, new Location(0, 0, 20, "Player1"), gameMap, this); // 初始化玩家对象并传递this作为监听器
        mapPanel = new MapPanel(gameMap, player); // 创建地图面板
    }

    private void initUI() {
        setLayout(new BorderLayout());
        add(mapPanel, BorderLayout.CENTER);

        // ... 其他UI初始化代码 ...
    }

    @Override
    public void onPlayerMoved(Location newLocation) {
        // 更新UI以反映玩家的新位置
        // 这个方法将由Player类在玩家移动时调用
        // 您可以在这里更新地图面板或执行其他UI更新操作
        mapPanel.refreshPlayerLocation(newLocation);
        repaint();
    }

    private void handleKeyPress(KeyEvent e) {
        int dx = 0;
        int dy = 0;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                dy = -1;
                break;
            case KeyEvent.VK_DOWN:
                dy = 1;
                break;
            case KeyEvent.VK_LEFT:
                dx = -1;
                break;
            case KeyEvent.VK_RIGHT:
                dx = 1;
                break;
        }
        if (dx != 0 || dy != 0) {
            player.move(dx, dy); // 调用Player的move方法处理移动
        }
    }

    // ... 其他方法 ...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gameGUI = new GUI();
                gameGUI.setVisible(true);
            }
        });
    }
}