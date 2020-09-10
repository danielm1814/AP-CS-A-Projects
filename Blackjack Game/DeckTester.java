/**
 * Tester for the deck class
 */
public class DeckTester
{
   public static void main(String[] args)
   {
      Deck d = new Deck();
      System.out.println(d.getNumCards());
      System.out.println(d.getDeck());
      System.out.println(d.draw());
      System.out.println(d.draw());
      System.out.println(d.draw());
      System.out.println(d.getDeck());
      System.out.println(d.getDiscard());
      System.out.println(d.getNumCards());
      System.out.println(d);
      Deck d1 = new Deck();
      System.out.println(d1.getDeck());
      System.out.println(d1.draw());
      System.out.println(d1.draw());
      System.out.println(d1.draw());
      System.out.println(d1.getDeck());
      System.out.println(d1.getDiscard());
      System.out.println(d1);
      
      Deck test = new Deck();
      while (test.getNumCards() > 0) //To test reshuffle
      {
          test.draw();
        }
        test.draw();
        System.out.println(test);
   }
}
