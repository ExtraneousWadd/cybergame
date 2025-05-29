import java.util.ArrayList;

public class AssetCard extends Card {
    private int assets;
    private double exposureFactor;
    private String specialEffect;
    private String synergy;
    private int bonus;


    public AssetCard(String name, int assets, double exposureFactor, String specialEffect, String synergy, int bonus) {
        super(name, "Asset");
        this.assets = assets;
        this.exposureFactor = exposureFactor;
        this.specialEffect = specialEffect;
        this.synergy = synergy;
        this.bonus = bonus;
    }


    public AssetCard(String name, int assets, double exposureFactor, String specialEffect) {
        this(name, assets, exposureFactor, specialEffect, null, 0);
    }


    public int getAssets(ArrayList hand) {
        if (synergy == null) return assets;
        for (Object c : hand) {
            if (c instanceof AssetCard) {
                AssetCard ac = (AssetCard) c;
                if (synergy.equals(ac.getName())) {
                    return assets + bonus;
                }
            }
        }
        return assets;
    }


    public double getExposureFactor() {
        return exposureFactor;
    }


    public int getBonus() {
        return bonus;
    }


    public String getSynergy() {
        return synergy;
    }


    @Override
    public String getDescription() {
        return name + " (Assets: " + assets + ", EF: +" + exposureFactor + ") - " + specialEffect +
                (synergy != null ? " [Synergy: " + synergy + ", Bonus: " + bonus + "]" : "");
    }


    public boolean hasSynergy(Player player) {
        if (synergy == null || player == null) return false;


        int count = 0;
        for (Card c : player.getHand()) {
            if (c instanceof AssetCard) {
                AssetCard ac = (AssetCard) c;
                if (synergy.equals(ac.getSynergy())) {
                    count++;
                }
            }
        }
        return count > 1;
    }
}



