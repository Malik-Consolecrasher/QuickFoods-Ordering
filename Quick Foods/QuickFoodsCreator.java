import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Formatter;


public class QuickFoodsCreator {

    static Scanner  userInput = new Scanner(System.in);
    static Scanner userLines = new Scanner(System.in);

    public static void main(String[] args) {

        //Using User input to create a customer object
        System.out.println("Please Enter the Customer Order Number");
        int customerOrderNum = Integer.parseInt(userInput.nextLine());

        System.out.println("Please Enter the Customer Name");
        String customerName = userInput.nextLine();
        
        System.out.println("Please Enter the Customer Phone Number");
        String customerPhoneNum = userInput.next();

        System.out.println("Please Enter the Customer Address");
        String customerAddress = userLines.nextLine();

        System.out.println("Please Enter the Customer City");
        String customerCity = userLines.nextLine();

        System.out.println("Please Enter the Customer Email");
        String customerEmail = userInput.next();



        //Using user input to create Resturant object
        System.out.println("Please Enter the Resturant Name");
        String resturantName = userLines.nextLine();

        System.out.println("Please Enter the Resturant Location");
        String resturantLocation = userLines.nextLine();

        System.out.println("Please Enter the Resturant Phone Number");
        String resturantNumber = userLines.nextLine();

        System.out.println("Please Enter the Order");
        String customerOrder = userLines.nextLine();

        System.out.println("Please Enter Any special Order Instructions");
        String specialInstructions = userLines.nextLine();

        System.out.println("Please Enter Total Order value");
        int orderCost = userLines.nextInt();

        //Creating new instances of a Customer and a Resturant respectivly, which will be used in creating an invoice
        Customer exampleCustomer = new Customer(customerOrderNum, customerName, customerPhoneNum, customerAddress, customerCity, customerEmail);
        Resturant exampleResturant = new Resturant(resturantName, resturantLocation, resturantNumber, customerOrder, specialInstructions, orderCost);

    

        System.out.println("\n\n"+exampleCustomer + "\n");
        System.out.println(exampleResturant + "\n");
        System.out.println(readDrivers(exampleCustomer, exampleResturant));
        userInput.close();

        createInvoice(exampleCustomer, exampleResturant);
    }




    // Function to read off the list of drivers and find the ideal driver for the customer 
    static String readDrivers(Customer exampleCustomer, Resturant exampleResturant){
        try {
            //Instantiating every needed variable

            File driverList = new File("./drivers.txt");
            Scanner driverFinder = new Scanner(driverList);
            String bestDriver = "";
            int smallestLoad = 1000000;

            //Checking every line of drivers.txt
            while ((driverFinder.hasNextLine())) {
                String currentListElement = driverFinder.nextLine();
                String[] driver = currentListElement.split(",");

                //If driver is in location of resturant, then check their number of orders, if it is less than the last driver, then make them the new best driver
                if (driver[1].equals(" " + exampleResturant.resturantLocation)){

                    if (!driver[2].equals(" ")){
                    int currentDriverLoad = Integer.valueOf(driver[2].replace(" ", ""));
                    

                    if (currentDriverLoad < smallestLoad){
                    bestDriver = driver[0];
                    smallestLoad = currentDriverLoad;
                    }
                }
                }
            }

            //If no driver is found in the same area, then there is no available driver
            if (bestDriver.equals("")){
                bestDriver = "Sorry, no available driver";
            }


            driverFinder.close();
            return bestDriver;

        } catch (FileNotFoundException e) {
            return "ERROR";
        }


    }


    static void createInvoice(Customer exampleCustomer, Resturant exampleResturant){

        String bestDriver = readDrivers(exampleCustomer, exampleResturant);

        try {
            Formatter invoiceCreator = new Formatter("./invoice.txt");


            //Prints out every needed variable in the format specified in the documentation
            invoiceCreator.format("%s", "Order number " + exampleCustomer.orderNumber);
            invoiceCreator.format("%s", "\nCustomer: " + exampleCustomer.customerName);
            invoiceCreator.format("%s", "\nEmail: " + exampleCustomer.emailAddress);
            invoiceCreator.format("%s", "\nPhone number: " + exampleCustomer.phoneNumber);
            invoiceCreator.format("%s", "\nLocation: " + exampleCustomer.customerCity + "\n");
            invoiceCreator.format("%s", "\nYou have ordered the following from " + exampleResturant.resturantName + " in " + exampleResturant.resturantLocation + ":");
            invoiceCreator.format("%s", "\n\n" + exampleResturant.order);
            invoiceCreator.format("%s", "\n\nSpecial instructions: " + exampleResturant.specialPreparation);
            invoiceCreator.format("%s", "\n\nTotal: R" + exampleResturant.totalPaid);
            invoiceCreator.format("%s", "\n\n" + bestDriver + " is nearest to the restaurant and so he/she will be delivering your order to you at:");
            invoiceCreator.format("%s", "\n\n" + exampleCustomer.customerAddress);
            invoiceCreator.format("%s", "\n\nIf you need to contact the restaurant, their number is " + exampleResturant.resturantContactNumber);


            invoiceCreator.close();

        } catch (FileNotFoundException e) {
            System.err.println("ERROR");
        }



    }
}
