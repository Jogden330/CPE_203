interface Socializer 
{
   // interface can have data - AUTOMATICALLY public and static
   public static int someMagicNumber = 42;
   
	void makeComment();
	public static void cool()
	{
		
		System.out.println(someMagicNumber);
	}
	void chitChat(String talkingTo);
}
