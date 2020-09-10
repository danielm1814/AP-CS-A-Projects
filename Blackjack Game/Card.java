/**
 * This is a class that can be used to create cards
 */
public class Card
{
        private String suit;
        private String rank;
        
        /**
         * Constructor that creates a card
         * @param theSuit
         * @param theRank
         */
        public Card (String theSuit, String theRank)
        {
            suit = theSuit;
            rank = theRank;
        }
        
        /**
         * @return the suit
         */
        public String getSuit()
        {
            return suit;
        }
        
        /**
         * @return the rank
         */
        public String getRank()
        {
            return rank;
        }
        
        
        /**
         * This is used to turn the given rank into a specific value 
         * 
         */
        public int getValue()
        {
            String r = rank;
            if (r.equalsIgnoreCase("Two") || r.equalsIgnoreCase("2"))
            {
                return 2;
            }
            if (r.equalsIgnoreCase("Three") || r.equalsIgnoreCase("3"))
            {
                return 3;
            }
             else if (r.equalsIgnoreCase("Four") || r.equalsIgnoreCase("4"))
            {
                return 4;
            }
             else if (r.equalsIgnoreCase("Five") || r.equalsIgnoreCase("5"))
            {
                return 5;
            }
             else if (r.equalsIgnoreCase("Six") || r.equalsIgnoreCase("6"))
            {
                return 6;
            }
             else if (r.equalsIgnoreCase("Seven") || r.equalsIgnoreCase("7"))
            {
                return 7;
            }
             else if (r.equalsIgnoreCase("Eight") || r.equalsIgnoreCase("8"))
            {
                return 8;
            }
             else if (r.equalsIgnoreCase("Nine") || r.equalsIgnoreCase("9"))
            {
                return 9;
            }
             else if (r.equalsIgnoreCase("Ten") || r.equalsIgnoreCase("10") || r.equalsIgnoreCase("Jack") || r.equalsIgnoreCase("Queen") || r.equalsIgnoreCase("King"))
            {
                return 10;
            }
             else if (r.equalsIgnoreCase("Ace")) //A method will be added later to change the value of an ace from 11 to 1
            {
                 return 11;
            }
            return 0;
        }
        
        /**
         * Returns a string version of a card
         * @returns toString
         */
        public String toString()
        {
            return rank + " of " + suit;
        }
}

