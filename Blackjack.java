import java.util.*;

class Blackjack {
    
    public static void main(String[] args) {
       
        //Input vom User 

        Scanner scanner = new Scanner(System.in);

        //ArrayList weil man bei Array nur eine bestimmte größe hat
        
        List<String> deck = new ArrayList<>(List.of(
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace",
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
        ));

        Collections.shuffle(deck);
        int playerTotal = 0;

        //das für den Player 2 zufällige Karten gezogen werden 
        
        playerTotal += getCardValue(deck.remove(0));
        playerTotal += getCardValue(deck.remove(0));

        System.out.println("Your cards: " + playerTotal);

        //es wird gefragt ob man ziehen will 
        
        while (playerTotal < 21) {
            System.out.println("1. Hit  2. Stand");
            int choice = scanner.nextInt();

            //falls man noch eine Karte zieht
            
            if (choice == 1) {
                playerTotal += getCardValue(deck.remove(0));
                System.out.println("Your cards: " + playerTotal);
            } else if (choice == 2) {
                break;
            }
        }

        // Keine Eingaben mehr 
        
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
