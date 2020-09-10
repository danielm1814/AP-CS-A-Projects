/**
 * This is a class that collects the player info and starts the game
 */
import java.util.Scanner;
public class Game
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println('\u000C');
        System.out.println("Welcome to our blackjack game\n");
        
        System.out.println("House Rules:");
        System.out.println("1. The dealer always hits if there value is less than or equal to 16");
        System.out.println("2. Blackjack gives you additional chips worth double of what you bet");
        System.out.println("3. Five Card Charlie gives you additional chips worth five times what you bet");
        System.out.println("4. If you got over 21 you automatically lose");
        System.out.println("5. You lose if your hand is worth less than the dealers");
        System.out.println("6. You win if your hand is worth less than 21 and more than the dealers");
        System.out.println("7. If the dealer busts you win");
        System.out.println("8. If you double down you get one card and your bet is doubled");
        
        System.out.println("Before we begin we are going to need to ask you a few simple questions");
        System.out.println("How many people are playing 1 or 2?");
        int players = sc.nextInt();
        while (players != 1 || players != 2)
        {
            if (players == 1 || players == 2)
            {
                break;
            }
            else
            {
                System.out.println("What you entered was invalid");
                System.out.println("How many people are playing 1 or 2?");
                players = sc.nextInt();
            }
        }
        if (players == 1)
        {
            System.out.println("First what is your name?");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println(name + " how many chips do you have?");
            int chips = sc.nextInt();
            while (chips < 0)
        {
            System.out.println("That is not possible please enter a new balance " + name + ". So how many chips do you have?");
            chips = sc.nextInt();
        }
            System.out.println(name + " how many decks would you like to have in the game?");
            int decks = sc.nextInt();
            Player player = new Player(name, chips);
            Dealer d1 = new Dealer(player, decks);
        }
        else if (players == 2)
        {
            System.out.println("First what is your name?");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println(name + " how many chips do you have?");
            int chips = sc.nextInt();
            while (chips < 0)
        {
            System.out.println("That is not possible please enter a new balance " + name + ". So how many chips do you have?");
            chips = sc.nextInt();
        }
            System.out.println(name + " how many decks would you like to have in the game?");
            int decks = sc.nextInt();
            System.out.println("What is your name player 2?");
            sc.nextLine();
            String name2 = sc.nextLine();
            System.out.println(name2 + " how many chips do you have?");
            int chips2 = sc.nextInt();
            while (chips2 < 0)
        {
            System.out.println("That is not possible please enter a new balance " + name2 + ". So how many chips do you have?");
            chips2 = sc.nextInt();
        }
            Player player = new Player(name, chips);
            Player player2 = new Player(name2, chips2);
            Dealer d1 = new Dealer(player, player2, decks);
        }
        
        
        
    }
}
