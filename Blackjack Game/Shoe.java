/**
 * This is a class of an arraylist of cards from a deck 
 */
import java.util.ArrayList;
public class Shoe
{
    private ArrayList<Card> shoe;
    private int numDecks;
    private ArrayList<Card> discard;
    /**
     * Constructs a shoe filled a number of decks
     */
    public Shoe(int num)
    {
        shoe = new ArrayList<Card>();
        discard = new ArrayList<Card>();
        numDecks = num;
        Deck trial = new Deck();
        for (int i = 0; i < num; i++)
        {
            for (int k = 0; k < 52; k++)
            {
                shoe.add(trial.getDeck().get(k));
            }
        }
    }
    /**
     * Returns all the cards in the shoe
     * @return deck
     */
    public ArrayList<Card> getShoe()
    {
        return shoe;
    }
    /**
     * Returns the number of cards left in the shoe
     * @return numCards
     */
    public int getNumCards()
    {
        return shoe.size();
    }
    /**
     * Returns all the discarded cards in the shoe
     * @return discard
     */
    public ArrayList<Card> getDiscard()
    {
        return discard;
    }
    /**
     * This draws a card from the shoe and removes it from the deck
     * @returns a card
     */
    public Card draw()
    {
        if (shoe.size() <= (shoe.size() + discard.size())*.25)
        {
            reshuffle();
        }
        discard.add(shoe.get(0));
        shoe.remove(0);
        return discard.get(discard.size()-1);
        
    }
    /**
     * This method refills the 25% full shoe with a refilled shoe
     */
    public void reshuffle()
    {
        discard.addAll(shoe);
        shoe.clear();
        while (discard.size() > 0)
        {
            int slot = (int)(Math.random()*discard.size());
            shoe.add(0, discard.get(slot));
            discard.remove(discard.get(slot));
        }
    }
    /**
     * This method shuffles what is currently in the shoe
     */
    public void shuffle()
    {
        ArrayList<Card> temp = new ArrayList<Card>();
        temp.addAll(shoe);
        shoe.clear();
        while (temp.size() > 0)
        {
           
            int slot = (int)(Math.random()*temp.size());
            shoe.add(0, temp.get(slot));
            temp.remove(temp.get(slot));
        }
    }
    /**
     * Returns a String version of a shoe
     * @return toString
     */
    public String toString()
    {
        String str = "";
        for (int i = 0; i < shoe.size() - 1; i++)
        {
            str = str + shoe.get(i) + ", ";
        }
        str = str + shoe.get(shoe.size()-1);
        return str;        
    }
}
