/**
 * A pile of sticks for playing simple nim.
 */
public class Pile
{
   private int sticksLeft;

   /**
    * Create a new Pile, with the specified number of sticks.
    * sticks must be non-negative.
    *
    * @param sticks the starting number of sticks for the pile
    */
   public Pile (int sticks)
   {
      sticksLeft = sticks;
   }

  /**
   * @return The number of sticks remaining in this Pile.
   */
   public int sticks() {return sticksLeft;}

   /**
    * Reduce the number of sticks by the specified amount.
    * numSticks must be non-negative and not greater than
    * this.sticks().
    *
    * @param numSticks the number of sticks to remove
    */
   public void remove (int numSticks)
   {
      sticksLeft = sticksLeft - numSticks;
   }
}
