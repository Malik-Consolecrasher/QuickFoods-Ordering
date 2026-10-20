public class Customer {

    // Initialise all variables for making a customer
    int orderNumber;
    String customerName;
    String phoneNumber;
    String customerAddress;
    String customerCity;
    String emailAddress;


    //Creating a customer object
    public Customer(int orderNumber, String customerName, String phoneNumber, String customerAddress, String customerCity, String emailAddress){
        
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.customerAddress = customerAddress;
        this.customerCity = customerCity;
        this.emailAddress = emailAddress;

    }

    // For testing purposes, allows me to see value of all customer variables
     public String toString(){
                String output ="Order Number: " + orderNumber;
                output += "\nName: " + customerName;
                output += "\nPhone Number: " + phoneNumber;
                output += "\nCustomer Address: " + customerAddress;
                output += "\nCity: " + customerCity;
                output += "\nEmail: " + emailAddress;

                return output;
            }
}
