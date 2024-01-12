import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Backpack {
    float totalWeight = 0;
    float totalValue = 0;
    public Backpack(int[] amount){
        totalWeight = 0;
        totalValue = 0;
        stuff = amount;
        for(int i=0;i<5;i++) {
            //System.out.printf("We selected "+ randomNumber +" of the thing"+i);
            Thing currentThing = Main.allTheThings.get(i);
            totalValue += currentThing.value*amount[i];
            totalWeight += currentThing.weight*amount[i];
            //System.out.println("Amount "+amount[i]+" position "+i);
        }
        CheckWeight();
    }


    //private List<Thing> things = new ArrayList<>();

    // if my weight is greater than the maximum allowed, we wont care about this individual
    //in the case of the weight being over the maximum we will put the value as -1 in order to show how disappointed we are on this individual
    void CheckWeight(){
        if (totalWeight > Main.constantMaximumWeightAllowed)
            totalValue = -1;
    }
    int []stuff = new int[5];
   public Backpack MakeNewBackpack1(int[] amount2){
        int[]childStuff = new int[5];
       Random random = new Random();
        for(int i=0;i<5;i++) {
            int mutation = random.nextInt(11) - 4;
            childStuff[i] = (stuff[i]*7 + amount2[i]*3)/10 + mutation;
        }
        return new Backpack(childStuff);
    }
    public Backpack MakeNewBackpack2(int[] amount2){
        int[]childStuff = new int[5];
        Random random = new Random();
        for(int i=0;i<5;i++) {
            int mutation = random.nextInt(7) - 3;
            childStuff[i] = (stuff[i]*3 + amount2[i]*7)/10 + mutation;
            if (childStuff[i]<0)
            {
                childStuff[i] = 0;
            }
        }
        return new Backpack(childStuff);
    }

    float ShowTotalValue(){
        return totalValue;
    }

    void ShowCombinationOfthings(){
        for(int i=0;i<5;i++){
            System.out.println("we selected "+stuff[i]+" out of things"+i);
        }
    }


    /*
    void AddThing(Thing thing){
        things.add(thing);
    }

    public Backpack() {
        Random random = new Random();
        for( int i = 0 ;i< Main.thingVariety;i++) {
            int randNumber = random.nextInt(Main.thingVariety);
            for(int j = 0 ;j< randNumber;j++)
                AddThing(Main.allTheThings[i]);
        }
    }

 public void randomBackpack() {
        Random random = new Random();
        totalValue=0;
        totalWeight=0;
        //generam random cate lucruri sunt in ghiozdan
        for(int i=0;i<5;i++) {
            int randomNumber = random.nextInt(5);
            stuff[i]=randomNumber;
            //System.out.printf("We selected "+ randomNumber +" of the thing"+i);
            Thing currentThing = Main.allTheThings.get(i);
            totalValue += currentThing.value*randomNumber;
            totalWeight += currentThing.weight*randomNumber;
        }
        CheckWeight();
    }
    public Backpa
    public void setBackpack(int[] amount){
        totalWeight=0;
        totalValue=0;
        for (int i=0;i<5;i++){
            this.stuff[i]=amount[i];
            Thing currentThing = Main.allTheThings.get(i);
            totalValue += currentThing.value*amount[i];
            totalWeight += currentThing.weight*amount[i];
        }

 */
}
