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
    private ArrayList<Card> mPlaced;

    public Hand(){
        mCards = new ArrayList<Card>();
        mPlaced = new ArrayList<Card>();
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

    public void printHand(){
        System.out.println("Your hand: ");
        System.out.println("------------------------------------");
        for(Card c : mCards) System.out.println(c.getName() + " of " + c.getSuit());
        System.out.println("------------------------------------");
    }

    public ArrayList<Card> checkHand(){
        ArrayList<Card> result;
        for(Card c : mCards){
            result = checkList(c);

            if(result == null) return null;
            else if(result.size() == 3) return result;
            else return null;
        }
        return null;
    }

    public ArrayList<Card> checkList(Card c){
        int count = 0;
        ArrayList<Card> result = new ArrayList<Card>();
        String name = c.getName();
        for(Card temp : mCards){
            if(name.equals(temp.getName())){
                count++;
                result.add(temp);
            }
        }
        if(count == 3) {
            removeFromHand(c);
            return result;
        }
        else{
            System.out.println("Sorry you don't have 3 of a kind");
            return null;
        }
    }


    public void removeFromHand(Card toRemove){
        int i = 0;
        String name = toRemove.getName();
        for(Card c : mCards){
            if(c.getName().equals(name)){
                mCards.remove(i);
            }
            i++;
        }
    }
}
