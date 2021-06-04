package oop.example;

import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*Exercise 10 - Self-Checkout
Working with multiple inputs and currency can introduce some tricky precision
issues.

Create a simple self-checkout system. Prompt for the prices and quantities of
three items. Calculate the subtotal of the items. Then calculate the tax using
a tax rate of 5.5%. Print out the line items with the quantity and total, and
then print out the subtotal, tax amount, and total.

Example Output:
Enter the price of item 1: 25
Enter the quantity of item 1: 2
Enter the price of item 2: 10
Enter the quantity of item 2: 1
Enter the price of item 3: 4
Enter the quantity of item 3: 1
Subtotal: $64.00
Tax: $3.52
Total: $67.52

Constraints:
-Keep the input, processing, and output parts of your program separate. Collect
the input, then do the math operations and string building, and then print out
the output.
-Be sure you explicitly convert input to numerical data before doing any
calculations.

Challenges:
Revise the program to ensure that prices and quantities are entered as numeric
values. Don’t allow the user to proceed if the value entered is not numeric.
Alter the program so that an indeterminate number of items can be entered.
The tax and total are computed when there are no more items to be entered.
 */

public class App 
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        App myApp = new App();
        String item1PriceString  = myApp.getPrice(1);
        double item1Price = myApp.convertStringToDouble(item1PriceString);
        String item1QuantityString = myApp.getQuantity(1);
        double item1Quantity = myApp.convertStringToDouble(item1QuantityString);

        String item2PriceString  = myApp.getPrice(2);
        double item2Price = myApp.convertStringToDouble(item2PriceString);
        String item2QuantityString = myApp.getQuantity(2);
        double item2Quantity = myApp.convertStringToDouble(item2QuantityString);

        String item3PriceString  = myApp.getPrice(3);
        double item3Price = myApp.convertStringToDouble(item3PriceString);
        String item3QuantityString = myApp.getQuantity(3);
        double item3Quantity = myApp.convertStringToDouble(item3QuantityString);

        double subtotal = myApp.calcSubtotal( item1Price, item1Quantity, item2Price, item2Quantity, item3Price, item3Quantity);
        double tax = myApp.calcTax(subtotal);
        double total = myApp.calcTotal(subtotal, tax);

        String message = myApp.generateMessage(subtotal, tax, total);
        System.out.print(message);
    }

    public String getPrice(int itemNum){
        System.out.print("Enter the price of item " + itemNum + ": ");
        String price = input.nextLine();
        return price;
    }

    public String getQuantity(int itemNum){
        System.out.print("Enter the quantity of item " + itemNum + ": ");
        String quantity = input.nextLine();
        return quantity;
    }

    public double convertStringToDouble(String word){
        return Double.parseDouble(word);
    }

    public double calcSubtotal(double item1Cost, double item1Quantity, double item2Cost, double item2Quantity, double item3Cost, double item3Quantity) {
        double item1 = item1Cost * item1Quantity;
        double item2 = item2Cost * item2Quantity;
        double item3 = item3Cost * item3Quantity;
        return (item1 + item2 + item3);
    }

    public double calcTax(double price){
        return (price * 0.055);
    }

    public double calcTotal(double subtotal, double tax){
        return (subtotal + tax);
    }

    public String generateMessage(double subtotal, double tax, double total){
        String subtotalString = String.format("%.2f", subtotal);
        String taxString = String.format("%.2f", tax);
        String totalString = String.format("%.2f", total);
        return ("Subtotal: $" + subtotalString + "\nTax: $" + taxString + "\nTotal: $" + totalString);
    }
}
