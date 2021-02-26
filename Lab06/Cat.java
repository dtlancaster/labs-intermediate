
/**
 * Class for Cat.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 *
 */
public class Cat extends Feline implements Pet
{
    /**
     * Constructor for Cat.
     * @param myZoo myZoo
     * @param name name
     */
    public Cat(Zoo myZoo, String name)
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
        System.out.println("purr...");
    }
}

