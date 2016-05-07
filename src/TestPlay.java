
import java.util.List;

/**
 * Created by jiangyiming on 5/7/16.
 */
public class TestPlay {
    public static void main(String[] args) {
        System.out.println("-----创建扑克牌-----");
        Poker poker = new Poker();
        List<Card> pokers = poker.createPoker();
        System.out.println("-----扑克牌创建完毕-----");
        for (Card o : pokers) {
            System.out.print(o.show(o.getPrefix(), o.getId()) + " ");
        }
        System.out.println("");
        System.out.println("-----开始洗牌-----");
        poker.shufflePoker(pokers);
        System.out.println("-----洗牌完毕-----");
        for (Card o : pokers) {
            System.out.print(o.show(o.getPrefix(), o.getId()) + " ");
        }
        System.out.println("-----创建玩家-----");
        System.out.println();
        System.out.println("请输入第一个玩家的ID和姓名:");
        Player p1 = poker.createPlayer();
        System.out.println("请输入第二个玩家的ID和姓名:");
        Player p2 = poker.createPlayer();
        System.out.println("欢迎玩家:" + p1.getName());
        System.out.println("欢迎玩家:" + p2.getName());
        System.out.println("-----开始发牌-----");
        System.out.println("玩家:" + p1.getName() + "-拿牌");
        poker.pickCard(p1, pokers);
        System.out.println("玩家:" + p2.getName() + "-拿牌");
        poker.pickCard(p2, pokers);
        System.out.println("玩家:" + p1.getName() + "-拿牌");
        poker.pickCard(p1, pokers);
        System.out.println("玩家:" + p2.getName() + "-拿牌");
        poker.pickCard(p2, pokers);
        System.out.println("-----发牌结束-----");
        System.out.println("-----开始游戏-----");
        poker.showMaxCard(p1);
        poker.showMaxCard(p2);
        Player winP = poker.compare(p1, p2);
        if (winP != null) {
            System.out.println("-----玩家:" + winP.getName() + "获胜!-----");
        } else {
            System.out.println("诶嘿!!这局平了");
        }
        System.out.println("玩家各自的手牌为:");
        poker.showCards(p1);
        poker.showCards(p2);
        System.out.println("ByeBye(●'◡'●)ﾉ♥");
    }
}
