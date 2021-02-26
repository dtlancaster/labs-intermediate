
/**
 * Class for Dog.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public class Dog extends Canine implements Pet
{
    /**
     * Constructor for Dog.
     * @param myZoo myZoo
     * @param name name
     */
    public Dog(Zoo myZoo, String name)
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

    /**
     * Play.
     */
    @Override
    public void play()
    {
        System.out.println("frolic...");
    }

    /**
     * Be friendly.
     */
    @Override
    public void beFriendly()
    {
        System.out.println("bark...");
    }
}

