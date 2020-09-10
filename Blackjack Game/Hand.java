/**
 * This is a class that resembles the hand that a player or dealer has in blackjack
 */
import java.util.ArrayList;
public class Hand
{
   private ArrayList<Card> hand;
   
  
    /**
     * Constructs a hand
     */
    public Hand()
    {
        hand = new ArrayList<Card>();
    }
    
    /**
     * Returns all the cards the in the hand
     * @return hand
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    
     /**
     * Returns a specified card in the hand
     * @return card
     */
    public Card getCard(int value)
    {
        if (value >= 0 && value < hand.size())
        {
            return hand.get(value);
        }
        return null;
    }
    
    /**
     * This adds a card to your hand
     * @param card
     */
    public void add(Card card)
    {
        hand.add(card);
        
    }
    
    /**
     * return the value of the hand
     * @return handValue
     */
    public int handValue()
    {
        int sum = 0;
        int ace = hand.size();
        for (Card c: hand)
        {
            
            if (!c.getRank().equalsIgnoreCase("Ace"))
            {
                sum = sum + c.getValue();
                ace--;
            }
        }
        
        for (int i = 0; i < ace; i++)
        {
            if (sum < 11)
            {
                sum = sum + 11;
            }
            else 
            {
                sum = sum + 1;
            }
        }
        return sum;
    }
    /**
     * Returns the number of cards in the hand
     * @return numCards
     */
    public int numCards()
    {
        return hand.size();
    }
     
    /**
     * This checks if the hand is busted
     * @return busted
     */
    public boolean bust()
    {
        if (handValue() <= 21)
        {
            return false;
        }
        return true;
    }
    
    /**
     * This checks if the hand is blackjack
     * @return blackjack
     */
    public boolean blackjack()
    {
        if (handValue() == 21 && hand.size() == 2)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the hand is five card charlie
     * return fiveCardCharlie
     */
    public boolean fiveCardCharlie()
    {
        if (handValue() <= 21 && hand.size() == 5)
        {
            return true;
        }
        return false;
    }
    
    /**
     * This empties the hand in order to play again
     */ 
    public void reset()
    {
        
        hand.clear();
    }
    
    /**
     * Turns your hand into a tostring
     * @return toString
     */
    public String toString()
    {
        String str = "";
        if (hand.size() == 0)
        {
            return str;
        }
        for (int i = 0; i < hand.size() - 1; i++)
        {
            str = str + hand.get(i) + ", ";
        }
        str = str + hand.get(hand.size()-1);
        return str;
    }
    
}
