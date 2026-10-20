public class Resturant {

    // Initialise all variables for making a Resturrant
    String resturantName;
    String resturantLocation;
    String resturantContactNumber;
    String order;
    String specialPreparation;
    double totalPaid;


    //Creating a resturant object
    public Resturant(String resturantName, String resturantLocation, String resturantContactNumber, String order, String specialPreparation, double totalPaid){
        this.resturantName = resturantName;
        this.resturantLocation = resturantLocation;
        this.resturantContactNumber = resturantContactNumber;
        this.order = order;
        this.specialPreparation = specialPreparation;
        this.totalPaid = totalPaid;
    }

    // For testing purposes, allows me to see value of all resturant variables
     public String toString(){
                String output ="Resturant Name: " + resturantName;
                output += "\nResturant Location: " + resturantLocation;
                output += "\nResturant Contact Number: " + resturantContactNumber;
                output += "\nOrder: " + order;
                output += "\nSpecial Preparation: " + specialPreparation;
                output += "\nTotal Paid: " + totalPaid;

                return output;
            }
}
