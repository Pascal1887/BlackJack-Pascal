import java.util.*;

class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> deck = new ArrayList<>(List.of(
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace",
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        ));

        Collections.shuffle(deck);
        int playerTotal = 0;

        playerTotal += getCardValue(deck.remove(0));
        playerTotal += getCardValue(deck.remove(0));

        System.out.println("Your cards: " + playerTotal);

        while (playerTotal < 21) {
            System.out.println("1. Hit  2. Stand");
            int choice = scanner.nextInt();
            if (choice == 1) {
                playerTotal += getCardValue(deck.remove(0));
                System.out.println("Your cards: " + playerTotal);
            } else if (choice == 2) {
                break;
            }
        }

        // TODO: Implement dealer logic and win/lose conditions

        scanner.close();
    }

    public static int getCardValue(String card) {
        if (card.equals("Jack") || card.equals("Queen") || card.equals("King")) {
            return 10;
        } else if (card.equals("Ace")) {
            return 11;
        } else {
            return Integer.parseInt(card);
        }
    }
}
