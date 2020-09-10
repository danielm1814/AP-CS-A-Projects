
/**
 * Tester for the shoe class
 */
public class ShoeTester
{
    public static void main(String[] args)
    {
      Shoe d = new Shoe(3);
      System.out.println("Expected 156: " + d.getNumCards()); //Should give 156 Cards
      System.out.println(d.getShoe()); //Should return the entire shoe
      System.out.println(d.draw()); // Should return the card you are drawing
      System.out.println(d.draw()); // Should return the card you are drawing
      System.out.println(d.draw()); // Should return the card you are drawing
      System.out.println(d.getShoe()); //Should return the orginal shoe besides the three drawn cards
      System.out.println(d.getDiscard()); // Should return the drawn cards
      System.out.println("Expected 153: " + d.getNumCards()); // Should return 153 cards
      System.out.println(d); //ToString of the current shoe
      
      Shoe test = new Shoe(3);
      while (test.getNumCards() > 39) //To test reshuffle
      {
          test.draw();
        }
        System.out.println("Expected 39: " + test.getNumCards()); //39 Cards
        System.out.println(test.draw()); //Draws the first card of a now refilled shoe
        System.out.println("Expected 155: " + test.getNumCards()); //155 Cards
        System.out.println(test); //Will have a shoe of 155 cards in a random order 
        
        System.out.println("\n");
        
        Shoe shuf = new Shoe(1);
        System.out.println(shuf); //Prints the original shoe
        System.out.println("Expected 52: " + shuf.getNumCards()); //52 Cards
        System.out.println(shuf.draw()); //Prints drawn card
        System.out.println("Expected 51: " + shuf.getNumCards()); //51 Cards
        shuf.shuffle();
        System.out.println(shuf); //Prints a shuffled shoe with every card, but drawn card 
        System.out.println("Expected 51: " + shuf.getNumCards()); //51 Cards left in deck
        
        
    
    }
}
