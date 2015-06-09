import java.util.*;

/**
 * This class is a representation of the 'Three of a Kind' card game.
 * Created by Jinxy on 01/06/2015.
 */
public class ThreeOfAKind{
    private ArrayList<Card> theDeck;
    private Stack<Card> thePile;
    private ArrayList<Player> winnerQueue,thePlayers;
    private int DECK_POINTER;

    ThreeOfAKind(){
        theDeck = new Deck().shuffleDeck();
        thePile = new Stack<Card>();
        thePlayers = new ArrayList<Player>();
        winnerQueue = new ArrayList<Player>();
        setThePlayersNames();
        thePlayers = distributeDeck(theDeck,thePlayers);
        DECK_POINTER = 0;
    }

    /***
     * Returns the number of players who want to play
     * @return - result can only be between 2 and 4 (including 2 and 4).
     */
    private int setThePlayers(){
        Scanner s = new Scanner(System.in);
        int size = 0;
        do{
            System.out.print("How many players are playing?: ");
            size = s.nextInt();
            System.out.println();

            if(size < 2 || size > 4)
                System.out.println("Sorry that was an invalid number of players."
                                   + "Max is 4 and minimum is 2");

        }while(size < 2 || size > 4);
        return size;
    }

    /***
     * A simple function that sets the players names to the desired inputs from the
     * user
     */
    private void setThePlayersNames(){
        Scanner s = new Scanner(System.in);

        int i = 0, size = setThePlayers();
        String temp = "";
        do{
            System.out.print("Please enter player " + i + "'s name: ");
            temp = s.nextLine();

            if(temp.equals("") || temp.equals(" "))
                System.out.println("Invalid name, please choose another.");
            else{
                thePlayers.add(new Player(temp));
                i++;
            }
        }while(size != i);
    }

    /***
     * This method will assign a card to each player until the deck passed in
     * is empty.
     * @return - the new list of players with a new hand.
     */
    private ArrayList<Player> distributeDeck(ArrayList<Card> c, ArrayList<Player> p){
        int i = 0, k = 0,j = 0;
        int numberOfDraws = p.size()*5, pSize = p.size();

        for(; i < numberOfDraws; i++){
            if(k == -1) break;

            if(j < pSize-1) j++;
            else j = 0;
            p.get(j).add(c.get(k));

            if(k < 52) k++;
            else k = -1;
        }
        if(k == -1) DECK_POINTER = -1;
        else DECK_POINTER = k + 1;
        return p;
    }

    /***
     *
     * @param c
     * @param index
     * @return
     */
    private Card drawAt(ArrayList<Card> c, int index){return c.get(index);}

    /***
     * This is the main method that will do the bulk of my work
     * I am not sure as of yet what to do with it.
     */
    public void game(){
        Scanner s = new Scanner(System.in);
        String currentPlayerName = "";
        String placed = "";
        int i = 0, round = 1;
        int choice = 0;
        int sizeP = thePlayers.size();
        Player currentPlayer = thePlayers.get(i);
        Card drawn, toBePlaced, topOfPile;
        do{
            currentPlayer = thePlayers.get(i);
            currentPlayerName = currentPlayer.getmName();
            System.out.println("Round "+round);
            System.out.println("It is: "+ currentPlayerName +" turn");

            if(round != 1){
                drawn = drawAt(theDeck,DECK_POINTER);
                DECK_POINTER++;
                System.out.println("You drew a: " + drawn.getName()+ " of " + drawn.getSuit());
                currentPlayer.add(drawn);
            }
            if(thePile.size() == 0){
                System.out.println("There is nothing in the pile");
            }
            else{
                topOfPile = thePile.peek();
                System.out.println("Top of the Pile: " + topOfPile.getName()+ " of " + topOfPile.getSuit());
            }
            do {
                System.out.println("------------------------------------");
                System.out.println(currentPlayerName + ", please choose an option");
                System.out.println("Please enter 1, 2 or 3 followed by ENTER");
                System.out.println("(1) - View Hand");
                System.out.println("(2) - Place down three valid cards");
                System.out.println("(3) - Place a card down from your hand");
                System.out.println("------------------------------------");

                choice = s.nextInt();

                switch(choice){
                    case 1:
                        currentPlayer.lookAtHand();
                        break;
                    case 2:
                        currentPlayer.checkHand();
                        currentPlayer.lookAtHand();
                        break;
                    case 3:
                        System.out.println("Choose a card to put down.");
                        currentPlayer.lookAtHand();
                        placed = s.nextLine();
                        toBePlaced = currentPlayer.placeDownCard(placed);

                        if(toBePlaced == null){
                            choice = 1;
                            System.out.println("Sorry that card doesn't exist");
                        }
                        else thePile.push(toBePlaced);
                        break;
                    default:
                        System.out.println("*************************************");
                        System.out.println("ERROR: that's an invalid choice! ");
                        System.out.println("Please enter 1, 2 or 3 followed by ENTER");
                        System.out.println("*************************************");
                }
            }while(choice == 1 || (choice > 3 && choice < 0 ));

            if(currentPlayer.getHand().getSize() == 0){
                System.out.println(currentPlayer.getmName() + " is out! They removed all their cards!");
                winnerQueue.add(currentPlayer);
                thePlayers.remove(i);
            }
            if(sizeP <= i){
                i = 0;
                round++;
            }
            else i++;

        }while(winnerQueue.size() != sizeP-1);
        System.out.println(winnerQueue.get(winnerQueue.size()-1).getmName() +" is the Winner! :D");
    }

    public static void main(String[] args){
        ThreeOfAKind test = new ThreeOfAKind();
        test.game();
    }
}
