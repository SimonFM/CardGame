/**
 * Created by Jinxy on 28/05/2015.
 *
 * Snap is a game based upon matching. Where players are given equal amount
 * of playing cards, they then place a card in to the pile, if two cards are
 * matching then the first player to call 'SNAP' gets the pile.
 *
 * Both players cannot see what cards they have and must draw the top card
 * from the deck.
 */
public class Snap {
    private Deck snapDeck;
    private Player[] mPlayers;
    private Hand mThePile;

    public Snap(int num){
        snapDeck = new Deck();
        mPlayers = new Player[num];
        mThePile = new Hand();
    }
}
