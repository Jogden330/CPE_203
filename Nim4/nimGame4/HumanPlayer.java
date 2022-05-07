import java.util.Scanner;

public class HumanPlayer implements Player
{
   private String name;
   private int sticksTaken;
    
   public HumanPlayer(String name)
   {
      this.name = name;
   }

   public String name() {return name;}
   public int sticksTaken() {return sticksTaken;}
    
   public void takeTurn(Pile pile) 
   {
      Scanner in = new Scanner(System.in);
      System.out.print(name + ", number of sticks to take: ");
      String numSticks = in.next();
      sticksTaken = Math.min(Integer.parseInt(numSticks), pile.sticks());
      pile.remove(sticksTaken);
   }
}