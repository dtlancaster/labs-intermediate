
/**
 * Class for FeralCat.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public class FeralCat extends Feline
{
    /**
     * Constructor for FeralCat.
     * @param myZoo myZoo
     * @param name name
     */
    public FeralCat(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    /**
     * Make noise.
     */
    @Override
    public void makeNoise()
    {
        System.out.println("meow...");
    }

    /**
     * Eat.
     */
    @Override
    public void eat()
    {
        System.out.println("pick...");
        setHungerLevel(getHungerLevel() - 3);
    }
}

