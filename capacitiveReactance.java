import java.util.*;

public class capacitiveReactance {
    public static final double PI = 3.14159;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What would your Frequency be? (measured in hertz): ");
        double f = scanner.nextInt();
        System.out.print("\nWhat would your Capacitance be? (measured in farads): ");
        double C = scanner.nextInt();
        solve(f, C);
    }
    public static void solve(double f, double C) {
        double Xc = 1/(2*PI*f*C);
        System.out.println("Capacitive reactance is (measured in ohms): " + Xc); 
    }
}