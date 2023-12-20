import java.util.*;

public class capacitiveReactance {
    public static final double PI = 3.14159;
    public static final String OHMS = "Capacitive Reactance (Ohms)";
    public static final String HERTZ = "Frequency (Hertz)";
    public static final String FARADS = "Capacitance (Farads)";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What are you trying to solve for?\n");
        System.out.println("Xc: Capacitive reactance         (measured in ohms)   = (1)");
        System.out.println("f : Frequency of the signal      (measured in hertz)  = (2)");
        System.out.println("C : Capacitance of the capacitor (measured in farads) = (3)\n");
        System.out.print("Pick (1, 2, 3): ");
        int solveFor = scanner.nextInt();
        String solveForString = "";
        String firstValueName = "";
        String secondValueName = "";
        double firstValueDouble = 0.0;
        double secondValueDouble = 0.0;
        if (solveFor == 1) {
            solveForString = OHMS;
            firstValueName = HERTZ;
            secondValueName = FARADS;
        } else if (solveFor == 2) {
            solveForString = HERTZ;
            firstValueName = OHMS;
            secondValueName = FARADS;
        } else if (solveFor == 3) {
            solveForString = FARADS;
            firstValueName = OHMS;
            secondValueName = HERTZ;
        }
        System.out.print("\nWhat would your " + firstValueName + " be?: ");
        firstValueDouble = scanner.nextDouble();
        System.out.print("\nWhat would your " + secondValueName + " be?: ");
        secondValueDouble = scanner.nextDouble();
        solve(firstValueDouble, secondValueDouble, solveForString);
    }
    public static void solve(double firstValueDouble, double secondValueDouble, String solveForString) {
        double answer = 1/(2*PI*firstValueDouble*secondValueDouble);
        System.out.println("\nIn this problem " + solveForString + " = " + answer);
        System.out.println("1 / ( 2 * " + PI + " * " + firstValueDouble + " * " + secondValueDouble + " ) = " + answer + " " +solveForString);
    }
}