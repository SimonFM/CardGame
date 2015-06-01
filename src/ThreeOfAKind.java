import java.util.ArrayList;

/**
 * Created by Jinxy on 01/06/2015.
 */
public class ThreeOfAKind {

    private ArrayList<Player> thePlayers;
    private Deck theDeck;

    ThreeOfAKind(){
        thePlayers = new ArrayList<Player>(3);
        theDeck = new Deck();
        theDeck.shuffleDeck();
    }
}
