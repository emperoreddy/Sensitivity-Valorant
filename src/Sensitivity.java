import java.lang.reflect.Array;
import java.util.Scanner;

public class Sensitivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Your dpi: ");
        double dpi = input.nextInt();

        // 280 is the eDpi of valorant, change to your own game's eDpi
        double medium = 280 / dpi;
        double high = medium * 1.5;
        double low = medium / 2;
        System.out.printf("H: %5.2f\t\t", high);
        System.out.printf("M: %5.2f\t\t", medium);
        System.out.printf("L: %5.2f\t\t", low);

        double[] sens = {high, medium, low};

        // loop until the number difference is very small
        while (sens[0] - sens[1] > 0.01) {
            System.out.println("What do you prefer: H | L");
            // choose the sens you want to keep, Medium with High or Medium with Low
            String choice = input.next();

            if (choice.equals("H") || choice.equals("h")) {
                double tempH = sens[1]; // tempH = medium
                sens[1] = (sens[0] + sens[1]) / 2;

                sens[2] = tempH; // medium goes to low position

            } else if (choice.equals("L") || choice.equals("l")) {
                double tempL = sens[1]; // tempL = medium
                sens[1] = (sens[2] + sens[1]) / 2;

                sens[0] = tempL; // medium goes to high position
            }

            System.out.printf("H: %5.3f\t\t", sens[0]); // print the new high
            System.out.printf("M: %5.3f\t\t", sens[1]); // print the new medium
            System.out.printf("L: %5.3f\t\t\n", sens[2]); // print the new low
        }

        System.out.printf("Your perfect sens is %5.3f", sens[1]); // print the perfect sens (medium)

    }
}

