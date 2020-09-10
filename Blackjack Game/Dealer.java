import java.util.Scanner;
/**
 * This creates a dealer that runs the blackjack game
 */
public class Dealer
{
   private Hand hand;
   private Player player;
   private Player player2;
   private Shoe shoe;
   private Hand splitHand;
   private boolean twoPlayers;
   Scanner sc = new Scanner(System.in);
    /**
    * Creates a dealer that starts the game with one player
    * @param player
    * @param numDecks
    */
   public Dealer(Player p,  int decks)
   {
       hand = new Hand();
       shoe = new Shoe(decks);
       player = p;
       twoPlayers = false;
       startGame();
   }
   
   /**
    * Creates a dealer that starts the game with two players
    * @param player
    * @param numDecks
    */
   public Dealer(Player p, Player p2, int decks)
   {
       hand = new Hand();
       shoe = new Shoe(decks);
       player = p;
       player2 = p2;
       twoPlayers = true;
       startGame2();
   }
   
   /**
    * This method will shuffle the deck
    * collect the bets
    * Deal two cards to each player
    */
    public void startGame()
    {
        shoe.shuffle();
        System.out.println("You currently have " + player.getChips() + " chips");
        System.out.println("How many chips would you like to bet?");
        int chips = sc.nextInt();
        while(chips > player.getChips() || chips < 0)
        {
            System.out.println("Sorry, you do not have that many chips.\nHow many chips would you like to bet?");
            chips = sc.nextInt();
        }
        player.bet(chips);
        System.out.println(player.getName() + " your bet is for " + player.getBet() + " chips");
        hand.add(shoe.draw());
        player.hit(shoe.draw());
        hand.add(shoe.draw());
        player.hit(shoe.draw());
        boolean p1 = player.getHand().blackjack();
        boolean p2 = hand.blackjack();
        if (p1 || p2)
        {
            endGame();
        }
        else 
        {
            playerTurn();
        }
    }
    
    /**
    * This method will shuffle the deck and works for two players
    * collect the bets
    * Deal two cards to each player
    */
    public void startGame2()
    {
        shoe.shuffle();
        System.out.println(player.getName() + " you currently have " + player.getChips() + " chips");
        System.out.println(player.getName() + " how many chips would you like to bet?");
        int chips = sc.nextInt();
        while(chips > player.getChips() || chips < 0)
        {
            System.out.println("Sorry, you do not have that many chips.\nHow many chips would you like to bet?");
            chips = sc.nextInt();
        }
        System.out.println(player2.getName() + " you currently have " + player2.getChips() + " chips");
        System.out.println(player2.getName() + " how many chips would you like to bet?");
        int chips2 = sc.nextInt();
        while(chips2 > player2.getChips() || chips2 < 0)
        {
            System.out.println("Sorry, you do not have that many chips.\nHow many chips would you like to bet?");
            chips2 = sc.nextInt();
        }
        player.bet(chips);
        player2.bet(chips2);
        System.out.println(player.getName() + " your bet is for " + player.getBet() + " chips");
        System.out.println(player2.getName() + " your bet is for " + player2.getBet() + " chips");
        hand.add(shoe.draw());
        player.hit(shoe.draw());
        player2.hit(shoe.draw());
        hand.add(shoe.draw());
        player.hit(shoe.draw());
        player2.hit(shoe.draw());
        boolean p1 = player.getHand().blackjack();
        boolean p2 = hand.blackjack();
        boolean p3 = player2.getHand().blackjack();
        if (p2)
        {
            endGame();
            
        }
        else if (p1 && p3)
        {
            endGame();
        }
        else if (p1)
        {
            player2Turn();
            System.out.println(player.getName() + " you got blackjack!!!");
        }
        else if (p3)
        {
            playerTurn();
            System.out.println(player2.getName() + " you got blackjack!!!");
        }
        else
        {
            playerTurn();
        }
    }
    
    /**
     * Ask the player if they will hit or stand with what they have
     */
    public void playerTurn()
    {
        System.out.println("\n");
        System.out.println(player.getName() + " it is now your turn");
        System.out.println(player.getName() + " your hand contains: " + player.getHand().toString());
        System.out.println("The value of your hand is " + player.getHand().handValue());
        System.out.println("One of the dealer's cards is a " + hand.getCard(0).toString());
        System.out.println("The current value of the dealer's hand is " + hand.getCard(0).getValue());
        sc = new Scanner(System.in);
        
        System.out.println(player.getName() + " would you like to double down?");
        String doubleDown = sc.nextLine();
        if (player.getBet()*2 <= player.getChips() && doubleDown.equalsIgnoreCase("Yes"))
        {
            player.bet(player.getBet() + player.getBet());
            System.out.println(player.getName() + " your bet has been changed to " + player.getBet() + " chips");
            Card card = shoe.draw();
            player.hit(card);
            System.out.println("You drew a " + card);
            System.out.println(player.getName() + " your final hand value is " + player.getHand().handValue());
            if (player.getHand().handValue() > 21)
            {
                endGame();
            }
            else if (player.getHand().handValue() > 21 && twoPlayers)
            {
                player2Turn();
            }
            else if (twoPlayers)
            {
                player2Turn();
            }
            else
            {
                dealerTurn();
            }
        }
        else
        {
            if (doubleDown.equalsIgnoreCase("yes"))
            {
                System.out.println("Sorry you can not double down");
            }
            System.out.println("\n");
            boolean hit = true;
            System.out.println(player.getName() + " would you like to hit or stand?");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Hit"))
            {
                Card add = shoe.draw();
                player.hit(add);
                System.out.println("You drew a " + add);
                System.out.println("\n");
                System.out.println(player.getName() + " your new hand contains: " + player.getHand().toString());
                System.out.println("The value of your hand is " + player.getHand().handValue());
                System.out.println("One of the dealer's cards is a " + hand.getCard(0).toString());
                System.out.println("The current value of the dealer's hand is " + hand.getCard(0).getValue());
                if (player.getHand().bust() && !twoPlayers)
                {
                    hit = false;
                    endGame();
                }
                else if (player.getHand().bust() && twoPlayers)
                {
                    hit = false;
                    player2Turn();
                }
            }
            else if (twoPlayers)
            {
                hit = false;
                player2Turn();
            }
            else
            {
                hit = false;
                dealerTurn();
            }
            while (hit)
            {
                System.out.println(player.getName() + " would you like to hit or stand?");
                choice = sc.nextLine();
                if (choice.equalsIgnoreCase("Hit"))
                {
                    Card add = shoe.draw();
                    player.hit(add);
                    System.out.println("You drew a " + add);
                    System.out.println("\n");
                    System.out.println("Your new hand contains: " + player.getHand().toString());
                    System.out.println(player.getName() + " the value of your hand is " + player.getHand().handValue());
                    System.out.println("One of the dealer's cards is a " + hand.getCard(0).toString());
                    System.out.println("The current value of the dealer's hand is " + hand.getCard(0).getValue());
                    if (player.getHand().bust() && !twoPlayers)
                    {
                        hit = false;
                        endGame();
                    }
                    else if (player.getHand().bust() && twoPlayers)
                    {
                        hit = false;
                        player2Turn();
                    }
                    else if (player.getHand().fiveCardCharlie() && !twoPlayers)
                    {
                        hit = false;
                        endGame();
                    }
                    else if (player.getHand().fiveCardCharlie())
                    {
                        hit = false;
                        player2Turn();
                    }
                }
                else if (twoPlayers)
                {
                    hit = false;
                    player2Turn();
                }
                else 
                {
                    hit = false;
                    dealerTurn();
                }
                System.out.println("\n");  
            }
        }
    }
    
    
    /**
     * Ask the second player if they will hit or stand with what they have
     */
    public void player2Turn()
    {
        
        System.out.println("\n" + player2.getName() + " it is now your turn");
        System.out.println(player2.getName() + " your hand contains: " + player2.getHand().toString());
        System.out.println("The value of your hand is " + player2.getHand().handValue());
        System.out.println("One of the dealer's cards is a " + hand.getCard(0).toString());
        System.out.println("The current value of the dealer's hand is " + hand.getCard(0).getValue());
        sc = new Scanner(System.in);
        
        System.out.println(player2.getName() + " would you like to double down?");
        String doubleDown = sc.nextLine();
        if (player2.getBet()*2 <= player2.getChips() && doubleDown.equalsIgnoreCase("Yes"))
        {
            player2.bet(player2.getBet() + player2.getBet());
            System.out.println(player2.getName() + " your bet has been changed to " + player2.getBet() + " chips");
            Card card = shoe.draw();
            player2.hit(card);
            System.out.println("You drew a " + card);
            System.out.println(player2.getName() + " your final hand value is " + player2.getHand().handValue());
            if (player2.getHand().handValue() > 21)
            {
                endGame();
            }
            else
            {
                dealerTurn();
            }
        }
        else
        {
            if (doubleDown.equalsIgnoreCase("yes"))
            {
                System.out.println("Sorry you can not double down");
            }
            System.out.println("\n");
            boolean hit = true;
            System.out.println(player2.getName() + " would you like to hit or stand?");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("Hit"))
            {
                Card add = shoe.draw();
                player2.hit(add);
                System.out.println(player2.getName() + " you drew a " + add);
                System.out.println("\n");
                System.out.println("Your new hand contains: " + player2.getHand().toString());
                System.out.println(player2.getName() + " the value of your hand is " + player2.getHand().handValue());
                System.out.println("One of the dealer's cards is a " + hand.getCard(0).toString());
                System.out.println("The current value of the dealer's hand is " + hand.getCard(0).getValue());
                if (player2.getHand().bust())
                {
                    hit = false;
                    endGame();
                }
            }
            else
            {
                hit = false;
                dealerTurn();
            }
            while (hit)
            {
                System.out.println(player2.getName() + " would you like to hit or stand?");
                choice = sc.nextLine();
                if (choice.equalsIgnoreCase("Hit"))
                {
                    Card add = shoe.draw();
                    player2.hit(add);
                    System.out.println("You drew a " + add);
                    System.out.println("\n");
                    System.out.println(player2.getName() + " your new hand contains: " + player2.getHand().toString());
                    System.out.println("The value of your hand is " + player2.getHand().handValue());
                    System.out.println("One of the dealer's cards is a " + hand.getCard(0).toString());
                    System.out.println("The current value of the dealer's hand is " + hand.getCard(0).getValue());
                    if (player2.getHand().bust() && player.getHand().bust())
                    {
                        hit = false;
                        endGame();
                    }
                    else if (player2.getHand().bust())
                    {
                        hit = false;
                        dealerTurn();
                    }
                    else if (player2.getHand().fiveCardCharlie() && !player.getHand().fiveCardCharlie())
                    {
                        hit = false;
                        dealerTurn();
                    }
                    else if (player2.getHand().fiveCardCharlie())
                    {
                        hit = false;
                        endGame();
                    }
                        
                }
                else
                {
                    hit = false;
                    dealerTurn();
                }
                System.out.println("\n");
            }
        }
    }
    
    /**
     * Runs the dealer's turn automatically if needed
     */
    public void dealerTurn()
    {
        System.out.println("\n");
        System.out.println("The other card in the dealer's hand is a " + hand.getCard(1));
        System.out.println("The dealer's hand includes: " + hand);
        System.out.println("The value of the dealer's hand is " + hand.handValue());
        while (hand.handValue() <= 16)
        {
            System.out.println("The dealer hits");
            Card card = shoe.draw();
            hand.add(card);
            System.out.println("The dealer drew a " + card);
            System.out.println("The value of the dealer's hand is now " + hand.handValue());
        }
        endGame();
    }
    
    /**
     * Compares the two hands and either gives the person chips returns the chips, or takes them
     */
    public void endGame()
    {
        System.out.println("\n");
        if (player.getHand().blackjack() && hand.blackjack())
        {
            System.out.println(player.getName() + " you and the dealer got blackjack");
        }
        else if (player.getHand().blackjack())
        {
            player.won();
            player.won();
            System.out.println(player.getName() + " You got blackjack and won " + player.getBet()*2 + " chips");
        }
        else if (hand.blackjack())
        {
            player.lost();
            System.out.println(player.getName() + " The dealer got blackjack and you lost " + player.getBet() + " chips");
        }
        else if (player.getHand().fiveCardCharlie())
        {
            player.won();
            player.won();
            player.won();
            player.won();
            player.won();
            System.out.println(player.getName() + " You got five card Charlie and won " + player.getBet()*5 + " chips");
        }
        else if (player.getHand().handValue() > 21)
        {
            player.lost();
            System.out.println(player.getName() + " You Busted!!! and lost " + player.getBet() + " chips");
        }
        else if (hand.handValue() > 21)
        {
            player.won();
            System.out.println(player.getName() + " The dealer busted!!! and you won " + player.getBet() + " chips");
        }
        else if (player.getHand().handValue() > hand.handValue())
        {
            player.won();
            System.out.println(player.getName() + " Your hand value is " + player.getHand().handValue() + " and the dealer's hand value is " + hand.handValue() + "\nYou Won " + player.getBet() + " chips");
        }
        
        else if (hand.handValue() > player.getHand().handValue())
        {
            player.lost();
            System.out.println(player.getName() + " Your hand value is " + player.getHand().handValue() + " and the dealer's hand value is " + hand.handValue() + "\nYou Lost " + player.getBet() + " chips");
            
        }
        else
        {
            System.out.println(player.getName() + " it was a tie");
        }
        System.out.println(player.getName() + " Your new chips total is " + player.getChips());
        
        if (twoPlayers)
        {
        if (player2.getHand().blackjack() && hand.blackjack())
        {
            System.out.println(player2.getName() + " you and the dealer got blackjack");
        }
        else if (player2.getHand().blackjack())
        {
            player2.won();
            player2.won();
            System.out.println(player2.getName() + " You got blackjack and won " + player2.getBet()*2 + " chips");
        }
        else if (hand.blackjack())
        {
            player2.lost();
            System.out.println(player2.getName() + " The dealer got blackjack and you lost " + player2.getBet() + " chips");
        }
        else if (player2.getHand().fiveCardCharlie())
        {
            player2.won();
            player2.won();
            player2.won();
            player2.won();
            player2.won();
            System.out.println(player2.getName() + " You got five card Charlie and won " + player2.getBet()*5 + " chips");
        }
        else if (player2.getHand().handValue() > 21)
        {
            player2.lost();
            System.out.println(player2.getName() + " You Busted!!! and lost " + player2.getBet() + " chips");
        }
        else if (hand.handValue() > 21)
        {
            player2.won();
            System.out.println(player2.getName() + " The dealer busted!!! and you won " + player2.getBet() + " chips");
        }
        else if (player2.getHand().handValue() > hand.handValue())
        {
            player2.won();
            System.out.println(player2.getName() + " Your hand value is " + player2.getHand().handValue() + " and the dealer's hand value is " + hand.handValue() + "\nYou Won " + player2.getBet() + " chips");
        }
        
        else if (hand.handValue() > player2.getHand().handValue())
        {
            player2.lost();
            System.out.println(player2.getName() + " Your hand value is " + player2.getHand().handValue() + " and the dealer's hand value is " + hand.handValue() + "\nYou Lost " + player2.getBet() + " chips");
            
        }
        else
        {
            System.out.println(player2.getName() + " it was a tie");
        }
        System.out.println(player2.getName() + " Your new chips total is " + player2.getChips());
    }
        
        
        System.out.println("Would you like to play again?");
        String newGame = sc.nextLine();
        player.getHand().reset();
        if (twoPlayers)
        {
           player2.getHand().reset(); 
        }
        hand.reset();
        
        
            if (player.getChips() == 0 && !twoPlayers)
            {
                System.out.println("Sorry, you are out of chips. Game Over!!!");
            }
            else if (!newGame.equalsIgnoreCase("Yes"))
            {
                System.out.println("Thanks for playing");
            }
            else if (player.getChips() == 0 && player2.getChips() == 0)
            {
                System.out.println("Sorry, one of you guys are out of chips. Game Over!!!");
            }
            else
            {
                System.out.println("Thanks for playing");
            }
            
        if (newGame.equalsIgnoreCase("Yes") && player.getChips() > 0 && !twoPlayers)
        {
            System.out.println('\u000C');
            startGame();
        }
        else if (newGame.equalsIgnoreCase("Yes") && player.getChips() > 0 && player2.getChips() > 0 && twoPlayers)
        {
            System.out.println('\u000C');
            startGame2();
        }
        
    
    }
   
}
