
/**
 * Class for WildDog.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public class WildDog extends Canine
{
    /**
     * Constructor for WildDog.
     * @param myZoo myZoo
     * @param name name
     */
    public WildDog(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    /**
     * Make noise.
     */
    @Override
    public void makeNoise()
    {
        System.out.println("bark...");
    }

    /**
     * Eat.
     */
    @Override
    public void eat()
    {
        System.out.println("slop...");
        setHungerLevel(getHungerLevel() - 3);
    }
}

