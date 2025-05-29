

import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> pool = new ArrayList<>();


    public Deck() {
        setupDeck();
        Collections.shuffle(deck);
        // Initial pool of 4 cards
        for (int i = 0; i < 4 && !deck.isEmpty(); i++) {
            pool.add(deck.remove(0));
        }
    }


    private void setupDeck() {
       /*
       deck.add(new AssetCard("Crypto Wallet", 3, 0.3, "Bonus with Blockchain Network"));
       deck.add(new AssetCard("Cloud Storage", 4, 0.4, "EF -0.2 if paired with Backup"));
       deck.add(new AssetCard("IoT Devices", 2, 0.2, "Extra EF if Security < 3"));
       deck.add(new SecurityCard("Firewall Upgrade", 3));
       deck.add(new SecurityCard("Data Backup System", 4));
       deck.add(new ActionCard("Phishing Attack", "Opponent discards an Asset"));
       deck.add(new ActionCard("SQL Injection", "Remove one Security card"));
       deck.add(new AssetCard("VPN Service", 3, 0.25, "Reduces exposure"));
       deck.add(new SecurityCard("Anti-Malware", 2));
       deck.add(new ActionCard("DDoS Attack", "Skip opponent's next turn"));
       deck.add(new AssetCard("Encrypted Emails", 2, 0.15, "Bonus if paired with Security"));
       deck.add(new SecurityCard("Security Training", 3));
       deck.add(new AssetCard("Cloud Backup", 5, 0.3, "Restore assets if attacked"));
       deck.add(new ActionCard("Social Engineering", "Opponent reveals hand"));
       deck.add(new SecurityCard("Network Monitoring", 2));
       deck.add(new AssetCard("Mobile Devices", 1, 0.1, "Low exposure"));
       */
        deck.add(new AssetCard("1", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("2", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("3", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("4", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("5", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("6", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("7", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("8", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("9", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("10", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("10", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("10", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("10", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("14", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("10", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("10", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("10", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("10", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("14", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("20", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("21", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("22", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("23", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("24", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("25", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("26", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("27", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("28", 3, 0.3, "Bonus with Blockchain Network"));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
        deck.add(new AssetCard("bonus", 3, 0.3, "Bonus with Blockchain Network", "10", 10));
    }


    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }


    public Card drawFromDeck() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        }
        return null;
    }


    public ArrayList<Card> getPool() {
        return pool;
    }


    public Card pickFromPool(int index) {
        if (index >= 0 && index < pool.size()) {
            Card picked = pool.remove(index);
            if (!deck.isEmpty()) {
                pool.add(deck.remove(0));
            }
            return picked;
        }
        return null;
    }
}


