package lab06_TreasureChandler.src;

/*
* Treasure Chandler
* CS 16000-01 02/03, Fall Semester 2024
* Lab 6
*
*/
import java.util.Scanner;   // needed for the scanner class
import java.io.*;           // needed for the java.io class

public class LoopsFilesPennies {
    /**
     * 
     * @param args      entered values
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // variables declaration
        int pennies = 0, days, dayWhenOptionIPayLessOptionII = 0;
        double payRateOptionI, wages = 0, difference;
        boolean optionIPayLessOptionII = false;

        // problem 2:
        // instantiates a Scanner object to read from the console
        Scanner scan = new Scanner(System.in);

        /*
         * solicits to enter the pay rate of the first option (which is the $
         * per day)
         */
        System.out.println("Enter the pay rate for option I in $ per day " +
                            "for example, \"1000.0\"");
        payRateOptionI = scan.nextDouble();

        /*
         * solicits to enter an integer between 21 and 30 (which is the
         * amount of days worked)
         */
        System.out.println("Between the numbers of 21 and 30, enter " +
                            "how many days have been worked:");
        days = scan.nextInt();

        /*
         * filler statement to consume the remaining newline character
         * (to avoid any problems)
         */
        scan.nextLine();

        /*
         * this while loop simply validates the required bounds for the input.
         * the loop stops once the program recieves an acceptable input
         */
        while (!((days >= 21) && (days <= 30))) {
            /*
             * asks user to enter a correct value from 21-30, and assign
             * the value to the "days" variable
             */
            System.out.println(String.format("\nYour entered work days, %d " +
                                                "is not admissible, since it is " +
                                                "not within the required range.",
                                                days));
            days = scan.nextInt();

            // consume the remaining newline character
            scan.nextLine();
        }

        // this for loop iterates the days (how many days the user inputted)
        for (int i = 1; i <= days; ++i) {
            /*
             * for the first day, pennies are assigned the value of 1.
             * for each subsequent day, the amount of pennies double
             */
            if (i == 1) {
                pennies = 1;
            } else {
                /*
                 * after day 1, the pennies will always double until the loop
                 * stops
                 */
                pennies = pennies * 2;
            }

            if (!optionIPayLessOptionII) {
                difference = pennies / 100.0 - days * payRateOptionI;

                if (difference >= 0) {
                    /*
                     * determines the day for the first time the pay of
                     * option I is less than the pay of option II
                     */
                    dayWhenOptionIPayLessOptionII = i;
                    optionIPayLessOptionII = true;
                }
            }

            System.out.printf("Day %2d: %,15d\t%,12.2f\n", i, pennies,
                                i * payRateOptionI);
        }

        /*
         * once the iteration process is finished, assign the variable "wages"
         * to the dollar value that corresponds to the "pennies" value
         */
        wages = pennies / 100.0;

        // display the dollar total in the console
        System.out.printf("For %d days worked, the CS major earned $%.2f, " + 
                            "and the XX major earned $,.2f", days, pennies,
                            payRateOptionI);

        // // declare the file name (such as "wages.txt" for writing in the file)
        // String fileName;

        // // get the actual file name
        // System.out.println("Enter the file name, such as \"wages.txt\":");
        // fileName = scan.nextLine();

    } // end of main()

} // end of LoopsFilesPennies
