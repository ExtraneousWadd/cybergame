
public abstract class Card {
    protected String name;
    protected String type;


    public Card(String name, String type) {
        this.name = name;
        this.type = type;
    }


    public String getName() { return name; }
    public String getType() { return type; }
    public abstract String getDescription();
}
