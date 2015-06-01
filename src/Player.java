import java.util.ArrayList;

/**
 * Created by Jinxy on 28/05/2015.
 * A java class to represent the Player as an object. The player only has a
 * hand to interact with.
 */
public class Player {

    private String mName;
    private int mScore;
    private Hand myHand;

    public Player(String n){
        mName = n;
        mScore = 0;
        myHand = new Hand();
    }

    /***
     *
     * @return - the Name of the player.
     */
    public String getmName(){return mName;}

    /***
     *
     * @return - The score of the player.
     */
    public int getmScore(){return mScore;}

    /***
     *
     * @return - The player's hand.
     */
    public ArrayList<Card> lookAtHand(){
        return myHand.getHand();
    }

    /***
     *
     * @return -  the head of the player's Hand.
     */
    public Card getHead(){
        return myHand.drawHead();
    }
}
