
/**
 * Class for Feline.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public abstract class Feline extends Animal
{
    /**
     * Constructor for Feline.
     * @param myZoo myZoo
     * @param name name
     */
    public Feline(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    
    /**
     * Roam.
     */
    @Override
    public void roam()
    {
        System.out.println("felines like to roam alone...");
        setHungerLevel(getHungerLevel() + 1);
    }
}

