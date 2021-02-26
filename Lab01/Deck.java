/**
 * PlayingCard.java
 * 
 * @author Dylan Lancaster
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Deck represents a 52 PlayingCards in a deck.
 * 
 */
public class Deck
{

    /**
     * Number of cards.
     */
    public static final int NUM_CARDS = 52;
    private Random generator;
    private ArrayList<PlayingCard> deck;

    /**
     * Constructor creates 52 cards and adds them to ArrayList deck.
     */
    public Deck()
    {
        // Creates a random number generator to be used in shuffleDeck()
        generator = new Random();
        initialize();
    }

    /**
     * Constructor uses a parameter to set the random seed.
     * 
     * @param seed Seed for the random number generator.
     */
    public Deck(int seed)
    {
        generator = new Random(seed);
        initialize();
    }

    /**
     * Initializes a sorted deck.
     */
    public void initialize()
    {
        // TODO: Create the ArrayList that will hold the 52 cards
        deck = new ArrayList<PlayingCard>();

        // TODO: Add code here to create and add all cards to the deck.
        // The resulting order should be from TWO CLUBS, TWO DIAMONDS,
        // TWO HEARTS, TWO SPADES, THREE CLUBS, ..., ACE SPADES
        for (int i = 0; i < SuitsAndRanks.NUMRANKS; i++)
        {
            for (int j = 0; j < SuitsAndRanks.NUMSUITS; j++)
            {
                deck.add(new PlayingCard(
                    SuitsAndRanks.fetchRank(i),
                    SuitsAndRanks.fetchSuit(j))
                );
            }
        }
    }

    /**
     * Randomly shuffles the PlayingCard order in the ArrayList deck.
     */
    public void shuffleDeck()
    {
        Collections.shuffle(deck);
    }

    /**
     * Returns the PlayingCard at the 'index' in the deck.
     * 
     * @param index Index into the deck
     * @return The PlayingCard at that 'index'.
     */
    public PlayingCard getCard(int index)
    {
        // TODO return the playing card the 'index' in the deck.
        return deck.get(index);
    }

    /**
     * Returns a String representation of the Deck.
     * 
     * @return The string.
     */
    @Override
    public String toString()
    {
        // TODO: Return a String with all the cards in the deck
        // separated by an end line '\n' character.
        String str = "";
        for (PlayingCard card : deck)
        {
            str += card;
            str += "\n";
        }
        return str;
    }
}

