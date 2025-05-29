import java.util.ArrayList;

public class SecurityCard extends Card {
    private int securityBoost;
    private String specialEffect;
    private String synergy;
    private int bonus;


    public SecurityCard(String name, int securityBoost, String specialEffect, String synergy, int bonus) {
        super(name, "Security");
        this.securityBoost = securityBoost;
        this.specialEffect = specialEffect;
        this.synergy = synergy;
        this.bonus = bonus;
    }

    public SecurityCard(String name, int securityBoost, String specialEffect) {
        super(name, "Security");
        this.securityBoost = securityBoost;
        this.specialEffect = specialEffect;
        this.synergy = null;
        this.bonus = 0;
    }

    public int getSecurityBoost(ArrayList hand) {
        if (synergy == null) return securityBoost;
        for (Object c : hand) {
            if (c instanceof AssetCard) {
                AssetCard ac = (AssetCard) c;
                if (synergy.equals(ac.getName())) {
                    return securityBoost + bonus;
                }
            }
        }
        return securityBoost;
    }

    @Override
    public String getDescription() {
        return name + " (Security: " + securityBoost + ") - " + specialEffect +
                (synergy != null ? " [Synergy: " + synergy + ", Bonus: " + bonus + "]" : "");
    }
}

