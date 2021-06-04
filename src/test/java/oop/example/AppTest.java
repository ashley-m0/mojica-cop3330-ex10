package oop.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest 
{
    @Test
    public void includes_correct_amounts()
    {
        App myApp = new App();
        double item1Price = 25;
        double item1Quantity = 2;
        double item2Price = 10;
        double item2Quantity = 1;
        double item3Price = 4;
        double item3Quantity = 1;

        double subtotal = myApp.calcSubtotal( item1Price, item1Quantity, item2Price, item2Quantity, item3Price, item3Quantity);
        double tax = myApp.calcTax(subtotal);
        double total = myApp.calcTotal(subtotal, tax);

        String actualMessage = myApp.generateMessage(subtotal, tax, total);
        String expectedMessage = "Subtotal: $64.00\n" +
                "Tax: $3.52\n" +
                "Total: $67.52";

        assertEquals(expectedMessage, actualMessage);
    }
}
