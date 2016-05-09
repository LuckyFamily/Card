
import java.util.*;
import java.util.regex.*;

/**
 * Created by jiangyiming on 5/7/16.
 */
public class Poker {
    private Set<Integer> index = new HashSet<>();
    private Set<Integer> ids = new HashSet<>();
    private static final String USER_ID_REGEX = "[0-9]+";

    /**
     * 锵锵``创建扑克牌O(∩_∩)O~
     *
     * @return
     */
    public List<Card> createPoker() {
        List<Card> pokers = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            pokers.add(new Card("黑桃", i));
            pokers.add(new Card("红桃", i));
            pokers.add(new Card("方片", i));
            pokers.add(new Card("梅花", i));
        }
        return pokers;
    }

    /**
     * 哒哒哒``洗牌洗牌
     *
     * @param pokers
     */
    public void shufflePoker(List pokers) {
        Collections.shuffle(pokers);
    }

    /**
     * 创建玩家 play play play~~
     *
     * @return
     */
    public Player createPlayer() {
        int id;
        String sId;
        String name;
        Scanner console = new Scanner(System.in);
        Pattern pattern = Pattern.compile(USER_ID_REGEX); //[0-9]* would accept empty string
        while (true) {
            System.out.println("请输入ID:");
            sId = console.next();
            Matcher matcher = pattern.matcher(sId);
            if (matcher.matches()) {
                id = Integer.parseInt(sId);
                if (!ids.contains(id)) {
                    ids.add(id);
                    break;
                } else {
                    System.out.println("ID已经注册过,请重新输入一个ID:");
                }
            } else {
                System.out.println("输入的ID不是正整数,请重新输入ID");
            }
        }
        System.out.println("请输入姓名:");
        name = console.next();
        Player p = new Player(id, name);
        return p;
    }

    /**
     * 抽牌咯 keke
     *
     * @param p
     * @param pokers
     */
    public Player pickCard(Player p, List pokers) {
        int temp;
        Random random = new Random();
        do {
            temp = random.nextInt(52);
        } while (index.contains(temp));
        index.add(temp);
        Card card = (Card) pokers.get(temp);
        p.pcard.add(card);
        return p;
    }

    public Card maxCard(Player p) {
        Collections.sort(p.pcard);
        return p.pcard.get(1);
    }

    /**
     * 比大小``看谁厉害 哼哼
     *
     * @param p1
     * @param p2
     * @return
     */
    public Player compare(Player p1, Player p2) {
        Card card1 = maxCard(p1);
        Card card2 = maxCard(p2);
        if (card1.compareTo(card2) == 1) {
            return p1;
        } else if (card1.compareTo(card2) == -1) {
            return p2;
        } else {
            return null;
        }
    }

    /**
     * duang~我最大的手牌~~~
     *
     * @param p
     */
    public void showMaxCard(Player p) {
        Card c = maxCard(p);
        System.out.println("玩家:" + p.getName() + "最大手牌为:" + c.show(c.getPrefix(), c.getId()));
    }

    /**
     * 所有卡牌都在这了~喵~
     *
     * @param p
     */
    public void showCards(Player p) {
        Card c1 = p.pcard.get(0);
        Card c2 = p.pcard.get(1);
        System.out.println(p.getName() + ":[" + c1.show(c1.getPrefix(), c1.getId()) + "," + c2.show(c2.getPrefix(), c2.getId()) + "]");

    }
}
