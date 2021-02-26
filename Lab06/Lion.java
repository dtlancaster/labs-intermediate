
/**
 * Class for Lion.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public class Lion extends Feline
{
    /**
     * Constructor for Lion.
     * @param myZoo myZoo
     * @param name namew
     */
    public Lion(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    /**
     * Make noise.
     */
    @Override
    public void makeNoise()
    {
        System.out.println("roar...");
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

