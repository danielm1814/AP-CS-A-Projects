/**
 * This is a tester for the Card class
 * 
 */


public class CardTester
{
    public static void main(String[] args)
    {
        Card one = new Card ("Hearts", "Ten");
        System.out.println(one);
        System.out.println(one.getValue());
        System.out.println(one.getRank());
        System.out.println(one.getSuit());
        Card one1 = new Card ("Diamonds", "Five");
        System.out.println(one1);
        System.out.println(one1.getValue());
        System.out.println(one1.getRank());
        System.out.println(one1.getSuit());
        Card one2 = new Card ("Diamonds", "8");
        System.out.println(one2);
        System.out.println(one2.getValue());
        System.out.println(one2.getRank());
        System.out.println(one2.getSuit());
    }
}
