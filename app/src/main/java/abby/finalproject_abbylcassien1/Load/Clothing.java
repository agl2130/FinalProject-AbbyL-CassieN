package abby.finalproject_abbylcassien1.Load;

/**
 * Created by aglee on 4/6/16.
 */
public class Clothing {

    public String name;
    public String info;

    private Clothing() {
        this("", "");
    }

    Clothing(String name, String info) {
        this.name = name;
        this.info = info;
    }
}
