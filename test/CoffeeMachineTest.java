import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineTest {
@Test
    public void test(){
    CoffeeMachine test = new CoffeeMachine();
     int result = test.Money("blackcoffee");
     assertEquals(30,result);
}
@Test
public void thereismilk(){
    CoffeeMachine test = new CoffeeMachine();
    test.SetIngredient();
    Assertions.assertEquals(1.0,test.getMilk());

}
    public void thereisnomilk(){
        CoffeeMachine test = new CoffeeMachine();
        test.SetIngredient();
        Assertions.assertEquals(2.0,test.getMilk());

    }


}