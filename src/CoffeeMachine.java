import java.util.Scanner;

public class CoffeeMachine{
    private int Coffee_Count;
    private double water;
    private double milk;
    private double coffee_powder;
    private int milkcount;
    private int watercount;
    private int coffepowdercount;
    Scanner scan = new Scanner(System.in);

// konstruktor

    public CoffeeMachine() {
        System.out.println("----------------------");
        System.out.println("Coffee Machine");
        System.out.println("----------------------");
    }


    /*
     MilkCoffe Metoden är själva kaffet om du väljer att du vill ha en milkcoffe då körs denna metod
     den kontrollerar om det finns water,coffe powder, milk.
     Money då skickas värdet "milkcoffe" till Money metoden där den kollar pris mm..
     */

    private void MilkCoffee(){
        Money("milkcoffee");
        if(water<=0.3 || coffee_powder<=0 || milk<=0){
            IngredientCount();
            System.out.println("-------------------------");
            System.out.println("not enough ingredients.");
            System.out.println("-------------------------");

        } else if  (water >= 0.3 && coffee_powder >= 10 && milk >= 0.2) {
            System.out.println("--------------------------------------------------");
            System.out.println("Taking 10mg of Coffee Powder");
            System.out.println("Taking 0.2 liter of Water");
            System.out.println("Taking 0.3 liter of Milk");
            this.coffee_powder = coffee_powder - 10;
            this.water = water - 0.3;
            this.milk = milk - 0.2;

            Coffee_Count = Coffee_Count + 1;

            System.out.println("Your Milk Coffee is Ready.");
            System.out.println("--------------------------------------------------");
        }

        /*
     BlackCoffee Metoden är själva kaffet om du väljer att du vill ha en blackcoffe då körs denna metod
     den kontrollerar om det finns water,coffe powder, milk.
     Money då skickas värdet "blackcoffe" till Money metoden där den kollar pris mm..
     */

    }
    private void BlackCoffee(){
        Money("blackcoffee");

        if(water <= 0.3 || coffee_powder<=0){

            IngredientCount();
            System.out.println("-------------------------");
            System.out.println("not enough ingredients.");
            System.out.println("-------------------------");


        }  if (water >= 0.3 && coffee_powder >= 10) {
            System.out.println("---------------------------------");
            System.out.println("Taking 10mg of Coffee Powder");
            System.out.println("Taking 0.2 liter of Water");
            this.coffee_powder = coffee_powder - 10;
            this.water = water -0.3;
            Coffee_Count = Coffee_Count + 1;

            System.out.println("Your Black Coffee is Ready.");
            System.out.println("--------------------------------");
        }

    }

    /*
        Money metoden tar emot pengar du sätter in för att kunna köpa, du anger hur mycket pengar du vill sätta in
        tills det är så mycket som kaffet kostar, om det är för lite pengar du satt in så körs koden att du måste sätta in mer
     */

    public int Money(String Coffe){
        int money = 0;
        System.out.println("Stoppa in pengar i maskinen");
        System.out.println("hur mycket vill du stoppa in?");
        money += scan.nextInt();
        System.out.println("Maskinen tar emot dina pengar....");

        while(true){


        if(money == 20 && Coffe.equals("blackcoffee")){
            break;

        }
            if(money == 22 && Coffe.equals("milkcoffee")){
                break;

            }

        else if(money <= 19 && Coffe.equals("blackcoffee")){

            System.out.println("You need to insert more money the black coffee costs 20kr you have inserted " + money + "kr");
               money += scan.nextInt();


            }
        else if(money <= 21 && Coffe.equals("milkcoffee")){

            System.out.println("You need to insert more money the milk coffee costs 22kr you have inserted " + money + "kr");
            money += scan.nextInt();


        }

        else if(money > 20 && Coffe.equals("blackcoffee")){
            money = money-20;
            System.out.println("Maskinen tar emot dina pengar....");
            System.out.println("växlar tillbaka " + money+ "kr");
            break;
        }
        else if(money > 22 && Coffe.equals("milkcoffee")){
            money = money-22;
            System.out.println("Maskinen tar emot dina pengar....");
            System.out.println("växlar tillbaka " + money+ "kr");
            break;
        }

        }


        return  money;
    }

//MakeCoffee är en meny metod med if satser, om du väljer te.x 1 så körs koden under som är BlackCoffee(); och mainMenu();

    private void MakeCoffee(){
        System.out.println("----------------------------------------------");
        System.out.println("Chose Coffee");
        System.out.println("1: Black Coffee  20;- ");
        System.out.println("2: Milk Coffee   22;- ");
        System.out.println("----------------------------------------------");

        String Choice = scan.next();

        while(true){
            if(Choice.equals("1")){
                BlackCoffee();
                mainMenu();
                break;
            }
            if(Choice.equals("2")){
                MilkCoffee();
                mainMenu();
                break;
            } else{
                System.out.println("Choose a coffee please");
            }

            break;

        }
        Choice = scan.next();
    }

    // Denna metoden ska städa ur maskinen alla ingredienser så den ger värdet 0 till dem.

    private void CleanMachine(){
        System.out.println("--------------------------------------------------");
        System.out.println("Cleaning the machine....");
        System.out.println("the machine have been cleaned.");
        water = 0;
        milk = 0;
        coffee_powder = 0;
        System.out.println("--------------------------------------------------");
    }

    // denna metoden skriver ut alla ingredienser o visar hur mycket finns kvar
    private void GetIngredient(){
        System.out.println("-------------------Status-------------------------");
        System.out.println("Water: " + water + " Liter");
        System.out.println("Milk: " + milk + " Liter");
        System.out.println("Coffee Powder: " + coffee_powder + " Gram");
        System.out.println("--------------------------------------------------");

    }

    // denna metoden är för att fylla ingredienser då fylls det upp med värden.

    public void SetIngredient(){
        System.out.println("----------------------------------------------");

        System.out.println("filling up 1 liter water...");
        System.out.println("filling up 1 liter milk...");
        System.out.println("filling up 200 grams of coffee powder...");
        System.out.println("----------------------------------------------");
        water = water + 1;
        milk = 1;
        coffee_powder = 200;
    }



    /*
     denna metoden räknar hur många gånger en ingrediens har tagit slut, då adderas det med 1 på vilken ingrediens tar slut.
     */

    private void IngredientCount(){


        if(milk <= 0.2){
            milkcount += 1;
        }
        if(water <= 0.3){
            watercount += 1;
        }
        if(coffee_powder <= 10){
            coffepowdercount += 1;
        }
    }




// MainMenu för att göra ditt val vad du vill göra.

    public void mainMenu(){
        System.out.println("1: Status of Ingredient");
        System.out.println("2: Fill Ingredient");
        System.out.println("3: Clean Machine");
        System.out.println("4: Buy Coffee");
        System.out.println("5: How many Coffee have we made?");
        System.out.println("6: How many times have the ingredients run out");
        System.out.println("7: Exit");
        int choice = scan.nextInt();

        while (true){

            switch (choice){
                case 1:
                    GetIngredient();
                    break;
                case 2:
                    SetIngredient();
                    break;
                case 3:
                    CleanMachine();
                    break;
                case 4:
                    MakeCoffee();
                    break;
                case 5:
                    System.out.println("----------------------------------------------");
                    System.out.println("We have made " + Coffee_Count + " Coffee's");
                    System.out.println("----------------------------------------------");
                    break;
                case 6:
                    System.out.println("Milk " + milkcount + " times");
                    System.out.println("water " + watercount + " times");
                    System.out.println("coffe powder " + coffepowdercount + " times");
                    System.out.println("----------------------------------------------");
                    break;

                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("choose between 1-7");

            }
            System.out.println("1: Status of Ingredient");
            System.out.println("2: Fill Ingredient");
            System.out.println("3: Clean Machine");
            System.out.println("4: Buy Coffee");
            System.out.println("5: How many Coffee have we made?");
            System.out.println("6: How many times have the ingredients run out");
            System.out.println("7: Exit");
            choice = scan.nextInt();



        }




    }


// en getter för milk

    public double getMilk() {
        return milk;
    }
}
