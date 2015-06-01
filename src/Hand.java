import java.util.ArrayList;

/**
 * Created by Jinxy on 28/05/2015.
 * This class represents a hand a player would have during a card game.
 * It is basically just an arraylist of cards, not really needed, but
 * I liked to have it in anyway. :) It keeps everything ordered and
 * to have some structure.
 */
public class Hand {

    private ArrayList<Card> mCards;

    public Hand(){
        mCards = new ArrayList<Card>();
    }

    /**
     * Yup, this function adds a card to the player's hand.
     * @param c - the card you want to add.
     */
    public void addCard(Card c){ add(c);}

    /***
     * Yet again, it adds to a player's hand... It just calls
     * the built in java arraylist.add() method.
     * @param c - the card you want to add.
     */
    private void add(Card c){mCards.add(c);}

    /**
     * Yup, it returns the hand, so the entire arraylist.
     * @return - the entire hand of the player.
     */
    public ArrayList<Card> getHand(){return hand();}

    /**
     * Yup, it returns the hand, so the entire arraylist.
     * @return - the entire hand of the player.
     */
    private ArrayList<Card> hand(){return mCards;}

    /**
     * Returns just the head of the player's hand.
     * @return - the head of the player's hand.
     */
    public Card drawHead(){return getHead();}

    /**
     * Returns just the head of the player's hand.
     * @return - the head of the player's hand.
     */
    private Card getHead(){
        Card c = mCards.get(0);
        mCards.remove(0);
        return c;
    }
}
