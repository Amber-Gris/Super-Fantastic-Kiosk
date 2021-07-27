import java.util.Random;

/**
 * generate the random number
 * 
 * @author (Xin Li)
 * @version (23/04)
 */
public class LuckyDipGenerator
{
    private Random randomGenerator;
    
    public LuckyDipGenerator()
    {
        randomGenerator = new Random();
    }
    
    /**
     * get a random number from min(include) to max(exclude)
     */
    public int randomItem(int max, int min)
    {
        return randomGenerator.nextInt(max-min)+min; 
    }
}