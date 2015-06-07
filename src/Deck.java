import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jinxy on 25/05/2015.
 */
public class Deck {

    private Card[][] mDeck;
    private ArrayList<Card> mDrawn;
    private ArrayList<Card> mDeckList;

    public Deck(){
        mDeck = new Card[4][13];
        mDrawn = new ArrayList<Card>();
        mDeckList = new ArrayList<Card>();
        setUpDeck();
    }

    /***
     * This method sets up a deck in a sorted way. so in order...
     * Just is a big for loop, with a switch inside.... Nothing else to
     * really explain (or I'm just lazy tbh).
     */
    private void setUpDeck(){
        int i,j, mod = 0;
        String s = "";
        for(i = 0; i < 4;i++){
            mod = 2;
            s = determineSuit(i);
            for(j = 0; j < 13;j++){
                switch(mod){
                    case 2:
                        mDeck[i][j] = new Card("Two",j,s);
                        break;
                    case 3:
                        mDeck[i][j] = new Card("Three",j,s);
                        break;
                    case 4:
                        mDeck[i][j] = new Card("Four",j,s);
                        break;
                    case 5:
                        mDeck[i][j] = new Card("Five",j,s);
                        break;
                    case 6:
                        mDeck[i][j] = new Card("Six",j,s);
                        break;
                    case 7:
                        mDeck[i][j] = new Card("Seven",j,s);
                        break;
                    case 8:
                        mDeck[i][j] = new Card("Eight",j,s);
                        break;
                    case 9:
                        mDeck[i][j] = new Card("Nine",j,s);
                        break;
                    case 10:
                        mDeck[i][j] = new Card("Ten",j,s);
                        break;
                    case 11:
                        mDeck[i][j] = new Card("Jack",j,s);
                        break;
                    case 12:
                        mDeck[i][j] = new Card("Queen",j,s);
                        break;
                    case 13:
                        mDeck[i][j] = new Card("King",j,s);
                        break;
                    case 14:
                        mDeck[i][j] = new Card("Ace",j,s);
                        break;
                }
                mod++;
            }
        }
        for(i = 0; i < 4; i++){
            for(j = 0; j < 13; j++){
                mDeckList.add(mDeck[i][j]);
            }
        }
    }

    /***
     * Returns the type of suit.
     * @param t -
     * @return - the string representation of the int
     */
    private String determineSuit(int t){
        switch(t) {
            case 0: return "Spades";
            case 1: return "Clubs";
            case 2: return "Hearts";
            case 3: return "Diamonds";
        }
        return "Error_Nope - Determining Suit went wrong somehow.";
    }

    public Card[][] getmDeck(){
        return mDeck;
    }

    /***
     * Just a method to add furher encapsulation.
     * @return - the result of the drawRandomCard() method.
     */
    public Card drawRandom(){
        return drawRandomCard();
    }

    /***
     * A method to draw a Card... I can't remember why I made this... but
     * yeah here it is.
     * @param c
     * @return - it returns a card drawn from a deck.
     */
//    private boolean cardDrawn(Card c){
//        for(Card[] temp :  mDeck){
//            for(Card p : temp){
//                if( (c.getName().equals(p.getName())) && (c.getSuit().equals(p.getSuit()))  )
//                    return true;
//            }
//        }
//        return false;
//    }

    /***
     * Draws a Random card from the orginal deck.
     * @return - the card from the original deck.
     */
    private Card drawRandomCard() {
        Random iR = new Random(4);
        Random jR = new Random(13);

        int i = iR.nextInt(4);
        int j = iR.nextInt(13);

        while (lookUp(mDeck[i][j]) == true) {
            i = iR.nextInt(4);
            j = iR.nextInt(13);
        }
        mDrawn.add(mDeck[i][j]);
        return mDeck[i][j];
    }


    /**
     * Function that returns a the head of the deck.
     * @return - the Card that is at the head of the deck.
     */
    private Card drawHead(){return mDeckList.get(0);}



    public ArrayList<Card> shuffleDeck(){
        for (int i = 0 ; i < 52; i++){
            drawRandomCard();
        }
        ArrayList<Card> temp = mDrawn;
        mDrawn = new ArrayList<Card>();
        mDeckList = temp;
        return temp;
    }

    /***
     * A simple print deck function.
     */
    public void printDeck(){
        for(Card c : mDeckList){
            System.out.println(c.getName() + " of "+  c.getSuit());
        }
    }

    /***
     * This method is used to check to see if a Card has already been drawn in the
     * shuffle method.
     * @param t - the Card to look for
     * @return - true or false depending on the if the Card is in the deck or not.
     */
    private boolean lookUp(Card t){
        for(Card c : mDrawn){
            if( (t.getSuit().equals(c.getSuit()) ) && (t.getName().equals(c.getName()) ) ){
                return true;
            }
        }
        return false;
    }
    /***
     * This method will assign a card to each player until the deck passed in
     * is empty.
     * @return - the new list of players with a new hand.
     */
    public ArrayList<Player> distributeDeck(ArrayList<Card> c, ArrayList<Player> p){
        int i = 0;
        for(Card tempC : c){
            i = (i == p.size()) ? 0: i + 1;
            p.get(i).add(tempC);
        }
        return p;
    }


}
