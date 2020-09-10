/**
 * This is a class that will create a standard 52 card deck
 */
import java.util.ArrayList;
public class Deck
{
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    /**
     * Constructs a deck with 52 cards
     */
    public Deck()
    {
        deck = new ArrayList<Card>();
        discard = new ArrayList<Card>();
        String suit = "";
        suit = "Spades";
        deck.add(new Card(suit, "Ace"));
        deck.add(new Card(suit, "Two"));
        deck.add(new Card(suit, "Three"));
        deck.add(new Card(suit, "Four"));
        deck.add(new Card(suit, "Five"));
        deck.add(new Card(suit, "Six"));
        deck.add(new Card(suit, "Seven"));
        deck.add(new Card(suit, "Eight"));
        deck.add(new Card(suit, "Nine"));
        deck.add(new Card(suit, "Ten"));
        deck.add(new Card(suit, "Jack"));
        deck.add(new Card(suit, "Queen"));
        deck.add(new Card(suit, "King"));
        suit = "Diamonds";
        deck.add(new Card(suit, "Ace"));
        deck.add(new Card(suit, "Two"));
        deck.add(new Card(suit, "Three"));
        deck.add(new Card(suit, "Four"));
        deck.add(new Card(suit, "Five"));
        deck.add(new Card(suit, "Six"));
        deck.add(new Card(suit, "Seven"));
        deck.add(new Card(suit, "Eight"));
        deck.add(new Card(suit, "Nine"));
        deck.add(new Card(suit, "Ten"));
        deck.add(new Card(suit, "Jack"));
        deck.add(new Card(suit, "Queen"));
        deck.add(new Card(suit, "King"));
        suit = "Clubs";
        deck.add(new Card(suit, "King"));
        deck.add(new Card(suit, "Queen"));
        deck.add(new Card(suit, "Jack"));
        deck.add(new Card(suit, "Ten"));
        deck.add(new Card(suit, "Nine"));
        deck.add(new Card(suit, "Eight"));
        deck.add(new Card(suit, "Seven"));
        deck.add(new Card(suit, "Six"));
        deck.add(new Card(suit, "Five"));
        deck.add(new Card(suit, "Four"));
        deck.add(new Card(suit, "Three"));
        deck.add(new Card(suit, "Two"));
        deck.add(new Card(suit, "Ace"));
        suit = "Hearts";
        deck.add(new Card(suit, "King"));
        deck.add(new Card(suit, "Queen"));
        deck.add(new Card(suit, "Jack"));
        deck.add(new Card(suit, "Ten"));
        deck.add(new Card(suit, "Nine"));
        deck.add(new Card(suit, "Eight"));
        deck.add(new Card(suit, "Seven"));
        deck.add(new Card(suit, "Six"));
        deck.add(new Card(suit, "Five"));
        deck.add(new Card(suit, "Four"));
        deck.add(new Card(suit, "Three"));
        deck.add(new Card(suit, "Two"));
        deck.add(new Card(suit, "Ace"));
    }
    
    /**
     * Returns all the cards in the deck
     * @return deck
     */
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    /**
     * Returns the number of cards left in the deck
     * @return numCards
     */
    public int getNumCards()
    {
        return deck.size();
    }
    /**
     * Returns all the discarded cards in the deck
     * @return discard
     */
    public ArrayList<Card> getDiscard()
    {
        return discard;
    }
    /**
     * This draws a card from the deck and removes it from the deck
     * @returns a card
     */
    public Card draw()
    {
        if (deck.size() <= (discard.size() + deck.size())*.25)
        {
            reshuffle();
        }
        discard.add(deck.get(0));
        deck.remove(0);
        return discard.get(discard.size()-1);
        
    }
    /**
     * This method refills the empty deck with a shuffled deck
     */
    public void reshuffle()
    {
        discard.addAll(deck);
        deck.clear();
        while (discard.size() > 0)
        {
            int slot = (int)(Math.random()*discard.size());
            deck.add(0, discard.get(slot));
            discard.remove(discard.get(slot));
        }
    }
    /**
     * This method shuffles what is currently in the deck
     */
    public void shuffle()
    {
        ArrayList<Card> temp = new ArrayList<Card>();
        temp.addAll(deck);
        deck.clear();
        while (temp.size() > 0)
        {
           
            int slot = (int)(Math.random()*temp.size());
            deck.add(0, temp.get(slot));
            temp.remove(temp.get(slot));
        }
    }
    /**
     * Returns a String version of a deck
     * @return toString
     */
    public String toString()
    {
        String str = "";
        for (int i = 0; i < deck.size() - 1; i++)
        {
            str = str + deck.get(i) + ", ";
        }
         str = str + deck.get(deck.size()-1);
        return str;        
    }
     
}
