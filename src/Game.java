/**
 * Created by Jinxy on 28/05/2015.
 */
public class Game {
    /**
     * Calls the whole program.
     * @param args - I haven't added any.... yet...
     */
    public static void main(String[] args){
        Deck d = new Deck();
        System.out.println("Shuffling deck!");
        d.shuffleDeck();
        System.out.println("Deck Shuffled!");
        d.printDeck();
    }
}
