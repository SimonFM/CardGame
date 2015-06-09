import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jinxy on 28/05/2015.
 * A java class to represent the Player as an object. The player only has a
 * hand to interact with.
 */
public class Player {

    private String mName;
    private int mScore;
    private Hand myHand;
    private Stack<Card> played;

    public Player(String n){
        mName = n;
        mScore = 0;
        myHand = new Hand();
        played = new Stack<Card>();
    }

    public void add(Card c){ myHand.addCard(c);}
    /***
     * Sets the player's name.
     */
    public void setName(String s) {mName = s;}
    /***
     * Returns the name of the player.
     * @return - the Name of the player.
     */
    public String getmName(){return mName;}

    /***
     * gets the score for the player.
     * @return - The score of the player.
     */
    public int getmScore(){return mScore;}

    /***
     *
     * @return - The player's hand.
     */
    public void lookAtHand(){
        myHand.printHand();
    }

    public Hand getHand(){return myHand;}

    /***
     *
     * @return -  the head of the player's Hand.
     */
    public Card getHead(){
        return myHand.drawHead();
    }

    /***
     * A function that searches the player's hand for a passed card
     * @param card
     * @return - true if the card is there, otherwise false.
     */
    private boolean lookup(Card card){
        for(Card c : myHand.getHand()){
            if(c.getName().equals(card.getName()) && c.getSuit().equals(card.getSuit()))
                return true;
        }
        return false;
    }
    public ArrayList<Card> checkHand(){
        return myHand.checkHand();
    }

    /***
     * This method filters the choice made by the user and returns that
     * card, but also deletes that card from their hand
     * @param choice - name of card to delete.
     * @return the card that was deleted.
     */
    public Card placeDownCard(String choice){
        System.out.println(choice);
        String[] parts = choice.split(" ");
        System.out.println(parts.length);
        System.out.println("DURRR "+ parts[0] + " of " +parts[2]);
        Card result = new Card(parts[0],0,parts[2]);

        if(lookup(result)){
            myHand.removeFromHand(result);
            return result;
        }
        else{
            return null;
        }
    }
}
