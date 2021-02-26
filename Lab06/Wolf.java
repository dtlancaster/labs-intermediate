
/**
 * Class for Wolf.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public class Wolf extends Canine
{
    /**
     * Constructor for Wolf.
     * @param myZoo myZoo
     * @param name name
     */
    public Wolf(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    /**
     * Make noise.
     */
    @Override
    public void makeNoise()
    {
        System.out.println("growl...");
    }

    /**
     * Eat.
     */
    @Override
    public void eat()
    {
        System.out.println("rip with teeth...");
        setHungerLevel(getHungerLevel() - 2);
    }
}

