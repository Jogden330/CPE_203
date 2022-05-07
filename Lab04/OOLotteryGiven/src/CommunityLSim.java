import java.util.*;

public final class CommunityLSim {

  ArrayList<Player> players; 
  int numPeeps;
  ArrayList<Integer> playThisYear;;
  Random random = new Random();

  //you will need to add more instance variables

  public CommunityLSim(int numP) {
		numPeeps = numP;
		//create the players
  		players = new ArrayList<Player>();

		//generate a community of 30
		for (int i = 0; i < numPeeps; i++) {
			if (i < numPeeps/2.0)
				players.add(new Player(PlayerKind.POORLY_PAID, (float)(99+Math.random()))); 
			else
				players.add(new Player(PlayerKind.WELL_PAID, (float)(100.1+Math.random()))); 
		}
	
	}

	public int getSize() {
		return numPeeps;
	}

	public Player getPlayer(int i) {
		return players.get(i);
	}

	public void addPocketChange() {

  		for(Player player: players){



  			switch (player.getKind()){
  				case WELL_PAID: player.addMoney(0.1f);
				break;
				case POORLY_PAID: player.addMoney(0.03f);
				break;
			}
  		}
	}

	private void reDoWhoPlays() {

		playThisYear = new ArrayList<Integer>();

		randomUniqIndx( 9, 0, 14);
		randomUniqIndx( 6, 15, 29);

		for(int i=0;i<playThisYear.size();i++){
			System.out.print(playThisYear.get(i) + " ");
		}
		System.out.println(" ");

	}

	/* generate some random indices for who might play the lottery 
		in a given range of indices */ 
 	public void randomUniqIndx(int numI, int startRange, int endRange) {
		ArrayList numbers = new ArrayList();
		for(int i = startRange; i < (endRange+1); i++)
		{
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		for(int i = 0; i < numI; i++){

			playThisYear.add((Integer) numbers.get(i));
		}
	}

	public void reDistribution(){

		if((random.nextInt(100) < 70)){
			int low = 15;
			int high = 29;

			int result = random.nextInt(high-low+1) + low;
			players.get(result).addMoney(1.0f);
		}
		else {
			int result = random.nextInt(15);
			players.get(result).addMoney(1.0f);

		}
	}
    
	public void simulateYears(int numYears) {
  		/*now simulate lottery play for some years */
		Game game = new Game();
  		for (int year=0; year < numYears; year++) {
			reDoWhoPlays();
			addPocketChange();
			game.winningLotNumber();

    		// add code so that each member of the community who plays, plays 
			//right now just everyone updates their list of funds each year
			for(Player p: players){
				p.setLost(false);
				p.updateMoneyEachYear();
			}

			for(int i = 0; i < playThisYear.size(); i++) {
				Player p = players.get(playThisYear.get(i));
				p.updateMoneyEachYear();
				p.playRandom();
				game.winnings(p,game.match(p.getLottoNumbers()));
				if(p.getLost())
					reDistribution();
//				System.out.println(Arrays.toString(p.getLottoNumbers()));
			}

			System.out.println("After year " + year + ":");
			mostAndLestMoney();
    	} //years
  }

  public void mostAndLestMoney() {
		float lestMoney = players.get(0).getMoney();
 		float mostMony = 0.0f;
		for(Player p: players){
			if(p.getMoney() > mostMony){
				mostMony = p.getMoney();
			}
			if(p.getMoney() < lestMoney){
				lestMoney = p.getMoney();
			}


		}

		System.out.println("The person with the most money has: " + mostMony);
	  	System.out.println("The person with the least money has: " + lestMoney);

  }




}
