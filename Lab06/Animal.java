
/**
 * Class for Animal.
 * 
 * @author Dylan Lancaster
 * @version 02/21/2020
 */
public abstract class Animal
{
    private String name;
    private Zoo zoo;
    private int hungerLevel;

    /**
     * Constructor for Animal.
     * @param myZoo myZoo
     * @param name name
     */
    public Animal(Zoo myZoo, String name)
    {
        setZoo(myZoo);
        setName(name);
        setHungerLevel(0);
    }

    /**
     * Make noise.
     */
    public abstract void makeNoise();
    
    /**
     * Eat.
     */
    public abstract void eat();
    
    /**
     * Sleep.
     */
    public void sleep()
    {
        System.out.println("sleeping...");
        setHungerLevel(10);
    }
    
    /**
     * Roam.
     */
    public void roam()
    {
        System.out.println("moving around...");
        setHungerLevel(getHungerLevel() + 1);
    }

    /**
     * Getter for name.
     * @return name name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for name.
     * @param name name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Getter for zoo.
     * @return zoo zoo
     */
    public Zoo getZoo()
    {
        return zoo;
    }

    /**
     * Setter for zoo.
     * @param zoo zoo
     */
    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }

    /**
     * Getter for hungerLevel.
     * @return hungerLevel hungerLevel
     */
    public int getHungerLevel()
    {
        return hungerLevel;
    }

    /**
     * Setter for hungerLevel.
     * @param hungerLevel hungerLevel
     */
    public void setHungerLevel(int hungerLevel)
    {
        // Limit hunger between 0 and 10
        hungerLevel = hungerLevel > 10 ? 10 : hungerLevel;
        hungerLevel = hungerLevel < 0 ? 0 : hungerLevel;
        
        this.hungerLevel = hungerLevel;
    }
}
