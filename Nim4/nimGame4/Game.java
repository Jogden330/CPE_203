import java.util.*;
/**
 * A game of Nim.
 *
 * @author Hatalsky/Workman
 * @version 2.0
 */
public class Game
{
   public static void main(String[] args)
   {
      Player p1, p2;
      Pile pile;
      int numSticks;
      Scanner in = new Scanner(System.in);
        
      System.out.println("Create Player 1...");
      p1 = createPlayer(in);
        
      System.out.println("\nCreate Player 2...");
      p2 = createPlayer(in);

      System.out.print("\nHow many sticks? ");
      numSticks = in.nextInt();
      pile = new Pile(numSticks);
        
      boolean done=false;
      while(!done)
      {
         done = play(p1, pile, p2);
         if (done)
         {
            System.out.println("\n" + p2.name()+ " is the winner!!!");
         }
         else
         {
            done = play(p2, pile, p1);
            if (done)
               System.out.println("\n" + p1.name()+ " is the winner!!!");
         }    
      }
   }
   public static Player createPlayer(Scanner in)
   {
      Player p;
      String name;
      int type;
      
      System.out.print("Player's name? ");
      name = in.next();
      
      System.out.print("Player type (0 - Greedy, 1 - Timid, 2 - Random, 3 - Smart, 4 - Human)? ");
      type = in.nextInt();
      
      if (type == 0)
      {
         in.nextLine(); // remove \n from input stream
         System.out.print("Taunt? ");
         String taunt = in.nextLine();  // gets whole line      
         p = new GreedyPlayer(name, taunt);
      }
      else if (type == 1)
         p = new TimidPlayer(name);  
      else if (type == 2)
         p = new RandomPlayer(name);
      else if (type == 3)
         p = new SmartPlayer(name);
      else
         p = new HumanPlayer(name);
      
      return p;   
   }
   
   public static boolean play(Player p, Pile pile, Player opponent)
   {
      System.out.println();
      if (p instanceof Socializer)
      {
         ((Socializer)p).chitChat(opponent.name());
         Socializer.cool();
         System.out.println(Socializer.someMagicNumber);
      }

      p.takeTurn(pile);
      System.out.println(p.name() + " takes " + p.sticksTaken() + " sticks.\n" +
       "There are " + pile.sticks() + " left in the pile.");
          
      if (p instanceof Socializer)
      {
         ((Socializer)p).makeComment();
      }
            
      if (pile.sticks() <= 0)
         return true;
      return false;      
   }
}

