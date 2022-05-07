import java.util.*;

class Player {
	private PlayerKind kind;
	private float money;
	private ArrayList<Float> moneyOverTime;
    Random random = new Random();
	private int red, green, blue;
	private int lottoNumbers[] = new int[5];
	private  ArrayList numbers = new ArrayList();
	private  boolean lost;

	//constructor
	public Player(PlayerKind pK, float startFunds) {
		kind = pK;
		money = startFunds;
		moneyOverTime = new ArrayList<Float>();
		moneyOverTime.add(startFunds);
		red = random.nextInt(100);
		green = random.nextInt(100);
		blue = random.nextInt(100);
		// add numbers to an array list
		for(int i = 0; i < 42; i++)
		{
			numbers.add(i+1);
		}
//		System.out.println(numbers);


		//overall blue tint to POORLY_PAID	
		if (kind == PlayerKind.WELL_PAID) {
			red += 100;
		} else {
			blue += 100;
		}
	}

	public int getR() { return red; }
	public int getG() { return green; }
	public int getB() { return blue; }
	public float getMoney() { return money; }
	public PlayerKind getKind() { return kind; }
	public ArrayList<Float> getFunds() { return moneyOverTime; }

	public void updateMoneyEachYear() {
		moneyOverTime.add(money);
	}

	public void addMoney(float money){
		this.money += money;
	}

	public int[] getLottoNumbers() {
		return lottoNumbers;
	}

	public void playRandom(){
		Collections.shuffle(numbers);

		for(int i = 0; i < lottoNumbers.length; i++){
			lottoNumbers[i] = (int) numbers.get(i);
		}
//		System.out.println(Arrays.toString(lottoNumbers));

	}
	public boolean getLost() {
		return lost;
	}

	public void setLost(boolean lost) {
		this.lost = lost;
	}


}
