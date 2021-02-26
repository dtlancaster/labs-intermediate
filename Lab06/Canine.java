
/**
 * Class for Canine.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public abstract class Canine extends Animal
{
    /**
     * Constructor for Canine.
     * @param myZoo myZoo
     * @param name name
     */
    public Canine(Zoo myZoo, String name)
    {
        super(myZoo, name);
    }
    
    /**
     * Roam method.
     */
    @Override
    public void roam()
    {
        System.out.println("like canines roam in packs...");
        setHungerLevel(getHungerLevel() + 1);
    }
}

