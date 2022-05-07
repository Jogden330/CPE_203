import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {

    private  int[] winningLotteryNumbers = new int[5];
    private ArrayList numbers = new ArrayList();


    public Game(){

        for(int i = 0; i < 42; i++)
        {
            numbers.add(i+1);
        }

    }

    public  void winningLotNumber(){

        Collections.shuffle(numbers);

        for(int i = 0; i < winningLotteryNumbers.length; i++){
            winningLotteryNumbers[i] = (int) numbers.get(i);
        }
//        System.out.println(Arrays.toString(winningLotteryNumbers));
    }

    public  int match(int[] numbers){
        int matches = 0;
        for(int i = 0; i < winningLotteryNumbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if (numbers[i] == winningLotteryNumbers[j]) {
                    matches++;
                }
            }
        }
        return matches;
    }

    public void winnings(Player player, int matchs){
        player.addMoney(-1.0f);

        switch(matchs){
           case 2:  player.addMoney(1.0f);
           break;
           case 3: player.addMoney(10.86f);
           break;
           case 4: player.addMoney(197.53f);
           break;
           case 5: player.addMoney(212534.83f);
           break;
           default: player.setLost(true);
        }
    }


}
