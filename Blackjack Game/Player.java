/**
 * The class for a player
 */

public class Player
{
    private String name;
    private int chips;
    private Hand hand;
    private int bet;
    
    /**
     * Creates a player
     */
    public Player(String n, int c)
    {
        name = n;
        chips = c;
        hand = new Hand();
    }
    /**
     * Returns the players name
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Returns the players hand
     * @return hand
     */
    public Hand getHand()
    {
        return hand;
    }
    
    /**
     * Returns the players number of chips
     * @return name
     */
    public int getChips()
    {
        return chips;
    }
    /**
     * Adds a card to the players hand if they want
     * @param card
     */
    public void hit(Card card)
    {
        hand.add(card);
    }
    
    /**
     * The player chooses to stop adding cards to the hand
     * returns the value of the final hand
     */
    public int stand()
    {
        return hand.handValue();
    }
    
    /**
     * Amount the player chooses to bet
     * @param bet
     */
    public void bet(int betValue)
    {
        bet = betValue;
    }
    
    /**
     * returns the value of the bet
     * @return bet
     */
    public int getBet()
    {
        return bet;
    }
    
    /**
     * adds chips if you win
     */
    public void won()
    {
        chips = chips + bet;
    }
    
    /**
     * Takes away chips if you lose
     */
    public void lost()
    {
        chips = chips - bet;
    }
}
