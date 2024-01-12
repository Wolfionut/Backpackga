import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//Mutatie

public class Main {
    public static Backpack[] backpackArray = new Backpack[40000];
    public static final float constantMaximumWeightAllowed = 1500;
    //public static final int thingVariety = 5;
    public static List<Thing> allTheThings = new ArrayList<>(); //put all the things here
    public static void main(String[] args) {
        Thing thing1 = new Thing(100,0.1f);
        Thing thing2 = new Thing(30,2f);
        Thing thing3 = new Thing(4,0.99f);
        Thing thing4 = new Thing(36,18);
        Thing thing5 = new Thing(12,3);
        allTheThings.add(thing1);
        allTheThings.add(thing2);
        allTheThings.add(thing3);
        allTheThings.add(thing4);
        allTheThings.add(thing5);
        RandomAmount randomAmount = new RandomAmount();
        //boolean ok = true;
        float highest_value=0;
        int positionOfHighestValue=-1;
        int i=0;
        while (i<50){
            Backpack backpack = new Backpack(randomAmount.ReturnAmountRandom());
            //backpack.randomBackpack();
            //backpack.CheckWeight();
            if (backpack.totalValue != -1) {
                backpackArray[i] = new Backpack(backpack.stuff);
               //System.out.println(backpackArray[i].ShowTotalValue());
                i++;
            }
            /*
            if (highest_value< backpack.ShowTotalValue()) {
                System.out.println();
                System.out.println();
                System.out.println();
                highest_value = backpack.ShowTotalValue();
                System.out.println("Highest value was updated to "+ highest_value);
                backpack.ShowCombinationOfthings();
                System.out.println("Weight of backpack is "+backpack.totalWeight);
            }
            */
        }
        /*
        //MakeGeneration1
        for(int X = 50;X<100;X+=2)
        {
            backpackArray[X]= backpackArray[X-50].MakeNewBackpack1(backpackArray[49-X].stuff);
            backpackArray[X+1]= backpackArray[X-50].MakeNewBackpack2(backpackArray[49-X].stuff);
        }
        for(int X = 100;X<150;X++)
        {
            backpackArray[X]= backpackArray[X-50].MakeNewBackpack1(backpackArray[X-49].stuff);
            X++;
            backpackArray[X]= backpackArray[X-51].MakeNewBackpack2(backpackArray[X-50].stuff);
        }
        for(int X = 150;X<200;X++)
        {
            backpackArray[X]= backpackArray[X-50].MakeNewBackpack1(backpackArray[X-49].stuff);
            X++;
            backpackArray[X]= backpackArray[X-51].MakeNewBackpack2(backpackArray[X-50].stuff);
        }
*/
        int gen=1;
        for( gen=1;gen<500;gen++){
            int X1 = 0;
            int X2 = 1;
            for( int X = 0;X<25;X++){
                //backpackArray[50*gen+X]= backpackArray[50*gen+X-50].MakeNewBackpack1(backpackArray[50*gen+X-49].stuff);
                //X++;
                //backpackArray[50*gen+X]= backpackArray[50*gen+X-51].MakeNewBackpack2(backpackArray[50*gen+X-50].stuff);
                backpackArray[50*gen+X1]=backpackArray[50*(gen-1)+X].MakeNewBackpack2(backpackArray[50*gen-X-1].stuff);
                backpackArray[50*gen+X2]=backpackArray[50*(gen-1)+X].MakeNewBackpack1(backpackArray[50*gen-X-1].stuff);
                X2 += 2;
                X1 += 2;

            }
        }

        String filePath = "individuals.txt";
        //Stergem continutul din fisier pentru a nu avea indivizii din run-ul anterior
        try {
            FileWriter fileWriter = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for( int j=0; j<gen*50;j++){
            //System.out.println("We are at bakckpack "+j);
            //System.out.println("The value is "+backpackArray[j].totalValue);
            //System.out.println("the weight is "+backpackArray[j].totalWeight);
            if (backpackArray[j].totalValue>highest_value) {
                highest_value = backpackArray[j].totalValue;
                positionOfHighestValue = j;
            }

            try {
                FileWriter fileWriter = new FileWriter(filePath, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\nBackpack number "+ j+" from generation "+ j/50);
                bufferedWriter.write("\nNumber of weights of type 1 is "+backpackArray[j].stuff[0]);
                bufferedWriter.write("\nNumber of weights of type 2 is "+backpackArray[j].stuff[1]);
                bufferedWriter.write("\nNumber of weights of type 3 is "+backpackArray[j].stuff[2]);
                bufferedWriter.write("\nNumber of weights of type 4 is "+backpackArray[j].stuff[3]);
                bufferedWriter.write("\nNumber of weights of type 5 is "+backpackArray[j].stuff[4]);
                bufferedWriter.write("\nTotal value is "+backpackArray[j].totalValue);
                bufferedWriter.write("\nTotal weight is "+backpackArray[j].totalWeight);
                bufferedWriter.write("\n");
                bufferedWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Weight of highest value is "+backpackArray[positionOfHighestValue].totalWeight);
        System.out.println("Highest value is "+highest_value);
        System.out.println("The position in array is "+positionOfHighestValue+" and the generation of this individual is "+positionOfHighestValue/50);
        System.out.println("Numbers of weights 1 is "+backpackArray[positionOfHighestValue].stuff[0]);
        System.out.println("Numbers of weights 2 is "+backpackArray[positionOfHighestValue].stuff[1]);
        System.out.println("Numbers of weights 3 is "+backpackArray[positionOfHighestValue].stuff[2]);
        System.out.println("Numbers of weights 4 is "+backpackArray[positionOfHighestValue].stuff[3]);
        System.out.println("Numbers of weights 5 is "+backpackArray[positionOfHighestValue].stuff[4]);
    }
}