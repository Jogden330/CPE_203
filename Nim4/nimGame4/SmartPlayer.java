public class SmartPlayer implements Player, Socializer
{
   private String name;
   private int sticksTaken;

   /**
   * Constructor for objects of class SmartPlayer
   */
   public SmartPlayer(String name)
   {
      this.name = name;
      sticksTaken = 0;
   }

   public String name() {return name;}
   public int sticksTaken() {return sticksTaken;}

   public void takeTurn(Pile pile) 
   {
      sticksTaken = (pile.sticks()-1)%4;
      
      if (sticksTaken == 0)
         sticksTaken = 1;

      pile.remove(sticksTaken);   
   }
   
   public void makeComment()
   {
      System.out.println("Yeah, Ima gonna win.");
   }
    
   public void chitChat(String talkingTo)
   {
      System.out.println("Hey, " + talkingTo + ", not a good move");
   }

}