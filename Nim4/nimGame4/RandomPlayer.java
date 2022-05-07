import java.util.Random;

public class RandomPlayer implements Player
{
    private String name;
    private int sticksTaken;
    private Random rand;
    
    public RandomPlayer(String name)
    {
          this.name = name;
          sticksTaken = 0;
          rand = new Random();
    }

    public String name() {return name;}
    public int sticksTaken() {return sticksTaken;}
    
    public void takeTurn(Pile pile) 
    {
       do
       {
          sticksTaken = rand.nextInt(3) + 1;
       } while (sticksTaken > pile.sticks());
       pile.remove(sticksTaken);
    }
}