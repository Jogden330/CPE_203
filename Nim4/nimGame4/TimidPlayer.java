public class TimidPlayer implements Player
{
    private String name;
    private int sticksTaken;
    
    /**
     * Constructor for objects of class TimidPlayer
     */
    public TimidPlayer(String name)
    {
          this.name = name;
          sticksTaken = 0;
    }

    public String name() {return name;}
    public int sticksTaken() {return sticksTaken;}
    
    public void takeTurn(Pile pile) 
    {
        pile.remove(1);
        sticksTaken = 1;    
    }
}