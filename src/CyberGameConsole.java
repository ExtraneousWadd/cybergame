import java.util.ArrayList;
import java.util.Scanner;


public class CyberGameConsole {
    public ArrayList<Player> players = new ArrayList<>();
    private Deck deck;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Card> pool = new ArrayList<>();


    public void startGame() {
        deck = new Deck();


        // Create players
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                name = "Player " + i;
            }
            players.add(new Player(name));
        }


        // Deal initial 3 cards to each player
        for (Player p : players) {
            for (int i = 0; i < 3; i++) {
                Card card = deck.drawFromDeck();
                if (card != null) {
                    p.addCard(card);
                }
            }
        }


        // Fill the pool initially
        for (int i = 0; i < 4; i++) {
            Card card = deck.drawFromDeck();
            if (card != null) {
                pool.add(card);
            }
        }


        // Play 12 turns (3 rounds per player)
        for (int turn = 1; turn <= 12; turn++) {
            Player currentPlayer = players.get((turn - 1) % players.size());
            System.out.println("\n--- Turn " + turn + " ---");
            System.out.println(currentPlayer.getName() + "'s turn.");


            showPlayerHand(currentPlayer);
            showPool();


            System.out.println("Choose a card from pool by number or type 'deck' to draw from deck:");
            String choice = scanner.nextLine().trim();


            if (choice.equalsIgnoreCase("deck")) {
                Card drawn = deck.drawFromDeck();
                if (drawn != null) {
                    System.out.println("You drew: " + drawn.getDescription());
                    currentPlayer.addCard(drawn);
                } else {
                    System.out.println("Deck is empty! You skip drawing.");
                }
            } else {
                try {
                    int index = Integer.parseInt(choice) - 1;
                    Card picked = deck.pickFromPool(index);
                    if (picked != null) {
                        System.out.println("You picked: " + picked.getDescription());
                        currentPlayer.addCard(picked);
                    } else {
                        System.out.println("Invalid choice or pool is empty.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. No card taken.");
                }
            }


            if (turn % players.size() == 0) {
                System.out.println("\n--- Scores after round " + (turn / players.size()) + " ---");
                for (Player p : players) {
                    System.out.println(p.getSummary());
                }
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
            }
        }


        // Final scores
        System.out.println("\n=== Game Over ===");
        System.out.println("Final Scores:");
        for (Player p : players) {
            System.out.println(p.getSummary());
        }
        System.out.println("Thanks for playing!");
    }


    private void showPlayerHand(Player player) {
        System.out.println(player.getName() + "'s Hand:");
        for (Card card : player.getHand()) {
            System.out.println(" - " + card.getDescription());
        }
    }


    private void showPool() {
        System.out.println("Card Pool:");
        for (int i = 0; i < pool.size(); i++) {
            System.out.println((i + 1) + ". " + pool.get(i).getDescription());
        }
    }


    public static void main(String[] args) {
        CyberGameConsole game = new CyberGameConsole();
        game.startGame();
    }
}
