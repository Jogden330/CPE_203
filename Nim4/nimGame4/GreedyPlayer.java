public class GreedyPlayer implements Player, Socializer
{
    private String name;
    private int sticksTaken;
    private String taunt;
    
    /**
     * Constructor for objects of class TimidPlayer
     */
    public GreedyPlayer(String name, String taunt)
    {
          this.name = name;
          this.taunt = taunt;
          sticksTaken = 0;
    }

    public String name() {return name;}
    public int sticksTaken() {return sticksTaken;}

    public void takeTurn(Pile pile) 
    {
        if (pile.sticks() > 3) 
           sticksTaken = 3;
        else 
            sticksTaken = pile.sticks();
         
        pile.remove(sticksTaken);
    }

    public void makeComment()
    {
       System.out.println(name + ": Haha! " + taunt);
    }
    
    public void chitChat(String talkingTo)
    {
        System.out.println(name + ": Hey " + talkingTo + ", you're gonna lose.");
    }

}
