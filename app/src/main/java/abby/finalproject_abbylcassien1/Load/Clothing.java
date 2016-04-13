package abby.finalproject_abbylcassien1.Load;

/**
 * Created by aglee on 4/6/16.
 */
public class Clothing {

    public String name;
    public String info;
    private boolean top;
    private boolean bottom;
    private boolean shoes;
    private boolean accessories;
    private boolean jacket;
    private boolean others;
    private boolean casual;
    private boolean business;
    private boolean nightOut;

    //  public String type;
    //public String occasion;
    //public photoId photo;

    private Clothing() {
    }

    Clothing(String name, String info) {
        this.name = name;
        this.info = info;
    }

    Clothing(String name, String info, boolean top, boolean bottom, boolean shoes, boolean accessories, boolean jacket, boolean others, boolean casual, boolean business, boolean nightOut) {
        this.name = name;
        this.info = info;
        this.top = top;
        this.bottom = bottom;
        this.shoes = shoes;
        this.accessories = accessories;
        this.jacket = jacket;
        this.others = others;
        this.casual = casual;
        this.business = business;
        this.nightOut = nightOut;
    }

    public boolean isTop() {
        return top;
    }

    public boolean isBottom() {
        return bottom;
    }


    public boolean isShoes() {
        return shoes;
    }

    public boolean isAccessories() {
        return accessories;
    }

    public boolean isJacket() {
        return jacket;
    }

    public boolean isOthers() {
        return others;
    }

    public boolean isCasual() {
        return casual;
    }

    public boolean isBusiness() {
        return business;
    }

    public boolean isNightOut() {
        return nightOut;
    }
}
