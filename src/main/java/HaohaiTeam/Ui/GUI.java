package HaohaiTeam.Ui;

import HaohaiTeam.game.Location;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private Map gameMap; // 游戏地图
    JButton playButton; // 游戏开始按钮
    private Player player; // 玩家对象

    private MapPanel mapPanel;
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
        player = new Player(gameMap); // 初始化玩家对象
    }

    private void initUI() {
        MapPanel mapPanel = new MapPanel(gameMap, player);

        setLayout(new BorderLayout());
        add(mapPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        playButton = new JButton("Play Game");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Game Started!");
                // 开始游戏后可以启用键盘监听器
                // 或者在构造函数中直接添加键盘监听器
            }
        });

        panel.add(playButton);
        add(panel);
    }

    private void handleKeyPress(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.moveUp(); // 向上移动
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.moveDown(); // 向下移动
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.moveLeft(); // 向左移动
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.moveRight(); // 向右移动
        }

        // 在这里需要更新地图面板以显示新的玩家位置
        mapPanel.refreshPlayerLocation(new Location(player.position.x, player.position.y)); // 假设Location类有一个合适的构造函数
        repaint();
    }

    // 添加Player类（假设已经实现）
    static class Player {
        private Point position;
        private Map gameMap;

        public Player(Map gameMap) {
            this.gameMap = gameMap;
            // 初始化玩家位置
            position = new Point(0, 0);
        }

        public void moveUp() { /* 实现向上移动 */ }
        public void moveDown() { /* 实现向下移动 */ }
        public void moveLeft() { /* 实现向左移动 */ }
        public void moveRight() { /* 实现向右移动 */ }
    }

    // 更新MapPanel类以包含玩家对象并根据玩家位置绘制
    static class MapPanel extends JPanel {
        private final Map gameMap;
        private final Player player;

        public MapPanel(Map gameMap, Player player) {
            this.gameMap = gameMap;
            this.player = player;
        }

        public void refreshPlayerLocation(Location location) {
            this.playerPosition = location; // 假设有一个成员变量 playerPosition 来存储当前玩家位置
            repaint(); // 重绘组件以显示新位置
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

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
            g.setColor(Color.RED);
            int x = player.position.x * gameMap.getTileSize();
            int y = player.position.y * gameMap.getTileSize();
            g.fillRect(x, y, gameMap.getTileSize(), gameMap.getTileSize());

            // 绘制玩家
            if (player != null) {
                int x = (int) (player.getPlayer_location().getX() * tileSize);
                int y = (int) (player.getPlayer_location().getY() * tileSize);
                g.setColor(Color.BLUE); // 玩家颜色
                g.fillOval(x, y, tileSize, tileSize); // 绘制玩家
            }
        }

        public void refreshPlayerLocation(Location location) {
            // 更新玩家位置的内部状态（如果需要）
            // ...

            repaint(); // 重绘整个面板以显示新的玩家位置
        }
    }

    public void updateMap() {
        refreshMap();
    }

    private void refreshMap() {
        // 用于刷新地图的方法实现
    }

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
