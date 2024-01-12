import java.util.Random;

public class RandomAmount {

    public int[] ReturnAmountRandom(){
        int[]stuff = new int[5];
        Random random = new Random();
        for (int i=0;i<5;i++){
            int randomNumber = random.nextInt(50);
            stuff[i]=randomNumber;
        }
        return stuff;
    }
}
