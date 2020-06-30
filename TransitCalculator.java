public class TransitCalculator {

    // Instance fields
    double days;
    double rides;
    String[] nameOfFare = new String[] {"Pay-per-ride (single ride)", "7-Day Unlimited Rides", "30-Day Unlimited Rides"};
    double[] priceOfFare = new double[] {2.75, 33.00, 127.00};

    // This is how you accept information from the main and set it equal to the instance fields
    public TransitCalculator(int numDays, int numRides) {
        days = numDays;
        rides = numRides;
    }
    public double unlimited7Price() {
       double numberOfWeeks = Math.ceil(days/7.0);
       double overallPrice = numberOfWeeks*priceOfFare[1];

       return overallPrice/rides;
    }

    public double[] getRidePrices() {

        //Price for Pay-per-ride (single ride)
        double pricePPR = priceOfFare[0];

        //Price for 7-Day Unlimited Rides
        double price7Day = unlimited7Price();

        //Price for 30-Day Unlimited Rides
        double price30Day = priceOfFare[2] / rides;

        double[] Prices = {pricePPR, price7Day, price30Day};
        return Prices;
    }

    public String getBestFare() {

        // Accessing the Array from getRidePrices()
        double[] ridePrices = getRidePrices();

        // Creating and assigning the variable "winningIndex" to be the variable where the best price is kept
        int winningIndex = 0;

        //Using a for loop to find the best fare
        for (int i = 0; i < priceOfFare.length; i++) {

            //using i to represent the index number for the ridePrices Array
            if (ridePrices[i] < ridePrices[winningIndex]) {
                winningIndex = i;
            }
        }
        //returned String statement
        return "You should get a " + nameOfFare[winningIndex] + " at the cost of $" + Math.round(ridePrices[winningIndex]* 100.00) /100.00 + " per ride.";
    }

    public static void main(String[] args) {
        // This is how you create a new instance and assign it values that will be its instance fields
        TransitCalculator number1 = new TransitCalculator(2, 1550);
        System.out.println(number1.getBestFare());
    }
}
