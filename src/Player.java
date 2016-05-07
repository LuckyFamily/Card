import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyiming on 5/7/16.
 */
public class Player {
    private int id;
    private String name;
    public List<Card> pcard;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.pcard = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
