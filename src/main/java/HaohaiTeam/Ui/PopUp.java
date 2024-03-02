package HaohaiTeam.Ui;

import javax.swing.JOptionPane;

public class PopUp {
    // 显示教育性信息的方法
    public void showEducationalMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Educational Info", JOptionPane.INFORMATION_MESSAGE);
    }
}