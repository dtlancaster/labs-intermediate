
/**
 * Class for Coyote.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public class Coyote extends Canine
{
    /**
     * Constructor for Coyote.
     * @param myZoo myZoo
     * @param name name
     */
    public Coyote(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    /**
     * Make noise.
     */
    @Override
    public void makeNoise()
    {
        System.out.println("howl...");
    }

    /**
     * Eat.
     */
    @Override
    public void eat()
    {
        System.out.println("gnaws...");
        setHungerLevel(getHungerLevel() - 2);
    }
}

