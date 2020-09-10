/**
 * Tester for the Hand Class
 */
public class HandTester
{
    public static void main(String[] args)
    {
        //Part1 - Uncomment to use handTesterWithCards()
        handTesterWithCards();
        
        //Part2 - Uncomment to use handTesterWithShoe()
        
        
        handTesterWithShoe();
        
    }
    
    /**
     *    In this helper method test your Hand.java by adding specific cards
     *    to the Hand. 
     * 
     *    Can you add cards?
     *    Can you get the value?
     *    Can you get the size?
     *    Can you clear the hand?
     *    Does it work for Blackjack?
     *    Does it bust?
     *    Can it handle Aces?
     *    Check A 2 A		
	 *			A 2 A K	    now what happens?
	 *			A 2 A A 8	I’ve got a lot of testers to fail with this order
     */ 
    public static void handTesterWithCards(){
        Card c1 = new Card ("Hearts", "Two");
        Card c2 = new Card ("Hearts", "Ace");
        Card c3 = new Card ("Hearts", "King");
        Card c4 = new Card ("Spades", "Eight");
        Card c5 = new Card ("Spades", "Ace");
        Card c6 = new Card ("Clubs", "Ace");
        Card c7 = new Card ("Diamonds", "King");
        
        Hand h1 = new Hand();
        h1.add(c1);
        System.out.println("Expecting: Two of Hearts\nActually: " + h1);
        h1.add(c2);
        System.out.println(h1);
        System.out.println("Expecting: 13\nActually: " + h1.handValue());
        System.out.println("Expecting: false\nActually: " + h1.bust());
        System.out.println("Expecting: false\nActually: " + h1.blackjack());
        System.out.println("Expecting: 2\nActually: " + h1.numCards());
        System.out.println("Expecting: false\nActually: " + h1.fiveCardCharlie());
        System.out.println(h1);
        System.out.println(h1.getHand());
        h1.reset();
        System.out.println("\n");
        System.out.println(h1);
        h1.add(c1);
        h1.add(c2);
        h1.add(c5);
        System.out.println("Expecting: 14\nActually: " + h1.handValue());
        System.out.println("Expecting: false\nActually: " + h1.bust());
        System.out.println("Expecting: false\nActually: " + h1.blackjack());
        System.out.println("Expecting: 3\nActually: " + h1.numCards());
        System.out.println("Expecting: false\nActually: " + h1.fiveCardCharlie());
        System.out.println(h1);
        System.out.println(h1.getHand());
        h1.reset();
        System.out.println(h1);
        System.out.println("\n");
        System.out.println(h1);
        h1.add(c3);
        h1.add(c2);
        System.out.println("Expecting: 21\nActually: " + h1.handValue());
        System.out.println("Expecting: false\nActually: " + h1.bust());
        System.out.println("Expecting: true\nActually: " + h1.blackjack());
        System.out.println("Expecting: 2\nActually: " + h1.numCards());
        System.out.println("Expecting: false\nActually: " + h1.fiveCardCharlie());
        System.out.println(h1);
        System.out.println(h1.getHand());
        h1.reset();
        System.out.println(h1);
        System.out.println("\n");
        System.out.println(h1);
        h1.add(c1);
        h1.add(c2);
        h1.add(c3);
        h1.add(c5);
        System.out.println("Expecting: 14\nActually: " + h1.handValue());
        System.out.println("Expecting: false\nActually: " + h1.bust());
        System.out.println("Expecting: false\nActually: " + h1.blackjack());
        System.out.println("Expecting: 4\nActually: " + h1.numCards());
        System.out.println("Expecting: false\nActually: " + h1.fiveCardCharlie());
        System.out.println(h1);
        System.out.println(h1.getHand());
        h1.reset();
        System.out.println(h1);
        System.out.println("\n");
        System.out.println(h1);
        h1.add(c1);
        h1.add(c2);
        h1.add(c3);
        h1.add(c5);
        h1.add(c6);
        System.out.println("Expecting: 15\nActually: " + h1.handValue());
        System.out.println("Expecting: false\nActually: " + h1.bust());
        System.out.println("Expecting: false\nActually: " + h1.blackjack());
        System.out.println("Expecting: 5\nActually: " + h1.numCards());
        System.out.println("Expecting: true\nActually: " + h1.fiveCardCharlie());
        System.out.println(h1);
        System.out.println(h1.getHand());
        h1.reset();
        System.out.println(h1);
        h1.add(c3);
        h1.add(c7);
        h1.add(c1);
        System.out.println(h1);
        System.out.println("Expecting: true\nActually: " + h1.bust());
        
        
        
    }
    
    /**
     *   In this helper method create a Hand and a Shoe. 
     * 
     *   Can you draw cards from the shoe and add them to the hand?
     *   Does the size of the Shoe work correctly?
     *   Do all of the Hand methods work correctly when interacting with the Shoe
     */ 
    public static void handTesterWithShoe(){
        System.out.println("\nNow we are adding the shoe");
        Shoe s = new Shoe(3);
        Hand h1 = new Hand();
        s.shuffle();
        Card d = s.draw();
        h1.add(d);
        System.out.println("Expected card from shoe: " + d);
        System.out.println("Card we drew from shoe: " + h1);
        System.out.println("Expected number of cards in shoe: 155" );
        System.out.println("Cards left in shoe: " + s.getNumCards());
    }
}
