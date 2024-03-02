package HaohaiTeam.data;

import java.util.List;

import HaohaiTeam.game.Location;
import HaohaiTeam.game.Player;
public class DataManager {
    // 保存玩家数据的方法
    public void savePlayerData(Player player) {
        // 这里应该有逻辑来保存玩家数据到文件或数据库
    }

    // 加载玩家数据的方法
    public Player loadPlayerData() {
        // 这里应该有逻辑来从文件或数据库中加载玩家数据
        return new Player("", 0, 0, 0, 0, new Location(0, 0, 0, ""));
    }
}
