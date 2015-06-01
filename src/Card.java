/**
 * Created by Jinxy on 25/05/2015.
 * A java class to represent a Card, with instance data of
 * the name and suit stored as Strings and the value at Int's
 */
public class Card {

    private String mName;
    private int mValue;
    private String mSuit;


    Card(String name, int value,String s){
        mSuit = s;
        mName = name;
        mValue = value;
    }

    /***
     * Returns the suit of the card.
     * So like Spades, Clubs, Diamonds etc
     * @return - String
     */
    public String getSuit(){
        return mSuit;
    }
    /***
     * Returns the name of the card.
     * so like Two, Ace, King, etc.
     * @return - String
     */
    public String getName(){
        return mName;
    }
    /***
     * Returns the value of the card.
     * so if it is Two it will be 2
     * Jack will be 11. etc
     * @return - Int
     */
    public int getValue(){
        return mValue;
    }

}
