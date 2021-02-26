
/**
 * Class for Hippo.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public class Hippo extends Animal
{
    /**
     * Constructor for Hippo.
     * @param myZoo myZoo
     * @param name name
     */
    public Hippo(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }

    /**
     * Make noise.
     */
    @Override
    public void makeNoise()
    {
        System.out.println("blub...");
    }

    /**
     * Eat.
     */
    @Override
    public void eat()
    {
        System.out.println("slurp...");
        setHungerLevel(getHungerLevel() - 1);
    }
}

