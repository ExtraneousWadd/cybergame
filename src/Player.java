import java.util.ArrayList;


public class Player {
    private String name;
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<AssetCard> assets = new ArrayList<>();
    private ArrayList<SecurityCard> security = new ArrayList<>();
    private double exposureFactor = 0;
    private int totalAssets = 0;
    private int totalSecurity = 1;


    public Player(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void addCard(Card card) {
        hand.add(card);
        if (card instanceof AssetCard) {
            AssetCard ac = (AssetCard) card;
            assets.add(ac);
            totalAssets += ac.getAssets(assets);
            exposureFactor += ac.getExposureFactor();
        } else if (card instanceof SecurityCard) {
            SecurityCard sc = (SecurityCard) card;
            security.add(sc);
            totalSecurity += sc.getSecurityBoost(security);
        }
    }


    public int calculateScore() {
        return totalAssets - ((int) (totalAssets * (exposureFactor) / totalSecurity));
    }


    public String getSummary() {
        return name + " | Score: " + calculateScore();
    }


    public ArrayList<Card> getHand() {
        return hand;
    }




}

