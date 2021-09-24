import java.util.Scanner;

public class Run{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CoffeeMachine coffee = new CoffeeMachine();
        System.out.println("Want to start the machine - Y or N ?");
        String Choice = scan.next();

        while (true){

        if(Choice.equals("y")  || Choice.equals("y")){
            coffee.mainMenu();
            break;
        }
        if(Choice.equals("n") || Choice.equals("N")){
            System.exit(0);
        }
        else{
            System.out.println("Error! Choose Y for Yes or N for No");

        }
            Choice = scan.next();


        }

    }


}
