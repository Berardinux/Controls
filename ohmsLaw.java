import java.util.*;

public class ohmsLaw {
  public static final String WATTS = "Power (Watts)";
  public static final String VOLTS = "Electromotive force (Volts)";
  public static final String AMPS = "Intensity (Amps)";
  public static final String OHMS = "Resistance (Ohms)";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nWhat are you trying to solve for?");
    values();
    int solveFor = scanner.nextInt();
    System.out.println("\nWhat is the first value do you have?");
    values();
    int valueOne = scanner.nextInt();
    solve(valueOne, 0, 0, 0, 0);
    double varOne = scanner.nextDouble();
    System.out.println("\nWhat is the second value you have?");
    values();
    int valueTwo = scanner.nextInt();
    solve(valueTwo, 0, 0, 0, 0);
    double varTwo = scanner.nextDouble();
    double result = solve(solveFor, valueOne, valueTwo, varOne, varTwo);
    System.out.println("\n" + result);

  }
  public static void nameOfValue(int valueName){

  }
  public static double solve(int solveFor, int valueOne, int valueTwo, double varOne, double varTwo) {
    double result = 0.0;
    String unknown = "";

    switch (solveFor) {
      case 1:
        unknown = WATTS;
        if (valueOne == 0) {
          System.out.println("How many " + unknown);
        } else {
          result = calculatePower(varOne, varTwo);
        }
        break;
      case 2:
        unknown = VOLTS;
        if (valueOne == 0) {
          System.out.println("How many " + unknown);
        } else {
          result = calculateVoltage(varOne, varTwo);
        }
        break;
      case 3:
        unknown = AMPS;
        if (valueOne == 0) {
          System.out.println("How many " + unknown);
        } else {
          result = calculateCurrent(varOne, varTwo);
        }
        break;
      case 4:
        unknown = OHMS;
        if (valueOne == 0) {
          System.out.println("How many " + unknown);
        } else {
          result = calculateResistance(varOne, varTwo);
        }
        break;
      default:
        System.out.println("Invalid choice. Please pick 1, 2, 3, or 4.");
        return 0.0;
    }
    if (valueOne != 0) {
      System.out.println("The result for " + unknown + " is: " + result);
    }
    return result;
  }
  public static double calculatePower(double varOne, double varTwo) {
    if (varOne == 2 && varTwo == 3) {
      // volts and amps
      return varOne * varTwo;
    } else if (varOne == 2 && varTwo == 4) {
      // volts and ohms
      return Math.pow(varOne, 2) / varTwo;
    } else if (varOne == 3 && varTwo == 4) {
      // amps and ohms
      return Math.pow(varOne, 2) * varTwo;
    } else {
      System.out.print("That was not a valid option");
      return 0.0;
    }
  }
  public static double calculateVoltage(double varOne, double varTwo) {
    if (varOne == 1 && varTwo == 3) {
      // watts and amps
      return varOne / varTwo;
    } else if (varOne == 1 && varTwo == 4) {
      // watts and ohms
      return Math.sqrt(varOne * varTwo);
    } else if (varOne == 3 && varTwo == 4) {
      // amps and ohms
      return varOne * varTwo;
    } else {
      System.out.print("That was not a valid option");
      return 0.0;
    }
  }
  public static double calculateCurrent(double varOne, double varTwo) {
    if (varOne == 1 && varTwo == 2) {
      // watts and volts
      return varOne / varTwo;
    } else if (varOne == 1 && varTwo == 4) {
      // watts and ohms
      return Math.sqrt(varOne / varTwo);
    } else if (varOne == 2 && varTwo == 4) {
      // volts and ohms
      return varOne / varTwo;
    } else {
      System.out.print("That was not a valid option");
      return 0.0;
    }
  }
  public static double calculateResistance(double varOne, double varTwo) {
    if (varOne == 1 && varTwo == 2) {
      // watts and volts
      return Math.pow(varTwo, 2) / varOne;
    } else if (varOne == 1 && varTwo == 3) {
      // watts and amps
      return varOne / Math.pow(varTwo, 2);
    } else if (varOne == 2 && varTwo == 3) {
      // volts and amps
      return varOne / varTwo;
    } else {
      System.out.print("That was not a valid option");
      return 0.0;
    }
  }
  public static void values() {
    System.out.println("P: Power               (Watts) = 1");
    System.out.println("E: Electromotive force (Volts) = 2");
    System.out.println("I: Intensity           (Amps)  = 3");
    System.out.println("R: Resistance          (Ohms)  = 4");
    System.out.print("\nPick (1, 2, 3, 4): ");
  }
}