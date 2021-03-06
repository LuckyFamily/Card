
/**
 * Created by jiangyiming on 5/7/16.
 */
public class Card implements Comparable<Card> {
    private String prefix;
    private int id;
    public enum Id{
        J,Q,K,A
    }
    public Card(String prefix, int id) {
        this.prefix = prefix;
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String show(String prefix, int id) {
        switch (id){
            case 10:return prefix+Id.J;
            case 11:return prefix+Id.Q;
            case 12:return prefix+Id.K;
            case 13:return prefix+Id.A;
            default:return prefix+id;
        }
    }


    @Override
    public int compareTo(Card o) {
        //先比较数字
        if (this.id < o.id) {
            return -1;
        } else if (this.id > o.id) {
            return 1;
        } else if (this.prefix.charAt(0) > o.prefix.charAt(0)) {//数字都相等的话再比较花色
            return 1;
        } else if (this.prefix.charAt(0) < o.prefix.charAt(0)) {
            return -1;
        } else
            return 0;
    }
}
