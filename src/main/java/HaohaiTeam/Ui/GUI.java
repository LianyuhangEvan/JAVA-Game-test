package HaohaiTeam.Ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton playButton; // 游戏开始按钮

    public GUI() {
        setTitle("Shared-Mobility Adventure Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        // 创建一个面板来容纳组件
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // 创建一个开始游戏的按钮
        playButton = new JButton("Play Game");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 当按钮被点击时，显示一个弹窗
                JOptionPane.showMessageDialog(null, "Game Started!");
            }
        });

        // 将按钮添加到面板
        panel.add(playButton);

        // 将面板添加到窗口
        add(panel);
    }

    public static void main(String[] args) {
        // 在事件分派线程中创建和显示GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gameGUI = new GUI();
                gameGUI.setVisible(true);
            }
        });
    }
}