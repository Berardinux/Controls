import java.util.*;

public class ohmsLaw {
  public static final String WATTS = "Power (Watts)";
  public static final String VOLTS = "Electromotive force (Volts)";
  public static final String AMPS = "Intensity (Amps)";
  public static final String OHMS = "Resistance (Ohms)";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    line();
    System.out.println("| What are you trying to solve for?  |");
    values();
    int solveFor = scanner.nextInt();
    System.out.print("\n( Nice were solving for ");
    solve(solveFor, 0, 0, 0, 0, true);
    System.out.print(" )\n\n");
    line();
    System.out.println("|What is the first value do you have?|");
    values();
    int valueOne = scanner.nextInt();
    System.out.print("\n┌─Okay cool the first value is \n|\n| : ");
    solve(valueOne, 0, 0, 0, 0, true);
    System.out.print("\n|\n└─> ");
    double varOne = scanner.nextDouble();
    System.out.println();
    line();
    System.out.println("| What is the second value you have? |");
    values();
    int valueTwo = scanner.nextInt();
    System.out.print("\n┌─Okay cool the second value is \n|\n| : ");
    solve(valueTwo, 0, 0, 0, 0, true);
    System.out.print("\n|\n└─> ");
    double varTwo = scanner.nextDouble();
    System.out.println();
    double result = solve(solveFor, valueOne, valueTwo, varOne, varTwo, false);
  }
  public static double solve(int solveFor, int valueOne, int valueTwo, double varOne, double varTwo, boolean var) {
    double result = 0.0;
    String unknown = "";

    switch (solveFor) {
      case 1:
        unknown = WATTS;
        if (var == true) {
          System.out.print(unknown);
        } else {
          result = calculatePower(valueOne, valueTwo, varOne, varTwo);
        }
        break;
      case 2:
        unknown = VOLTS;
        if (var == true) {
          System.out.print(unknown);
        } else {
          result = calculateVoltage(valueOne, valueTwo, varOne, varTwo);
        }
        break;
      case 3:
        unknown = AMPS;
        if (var == true) {
          System.out.print(unknown);
        } else {
          result = calculateCurrent(valueOne, valueTwo, varOne, varTwo);
        }
        break;
      case 4:
        unknown = OHMS;
        if (var == true) {
          System.out.print(unknown);
        } else {
          result = calculateResistance(valueOne, valueTwo, varOne, varTwo);
        }
        break;
      default:
        System.out.println("Invalid choice. Please pick 1, 2, 3, or 4.");
        return 0.0;
    }
    if (var == false) {
      System.out.println("\nThe result for " + unknown + " is: " + result);
    }
    return result;
  }
  public static double calculatePower(int valueOne, int valueTwo, double varOne, double varTwo) {
    if (valueOne == 2 && valueTwo == 3) {
      // volts and amps
      return varOne * varTwo;
    } else if (valueOne == 2 && valueTwo == 4) {
      // volts and ohms
      return Math.pow(varOne, 2) / varTwo;
    } else if (valueOne == 3 && valueTwo == 4) {
      // amps and ohms
      return Math.pow(varOne, 2) * varTwo;
    } else {
      System.out.print("\nThat was not a valid option\n ");
      return 0.0;
    }
  }
  public static double calculateVoltage(int valueOne, int valueTwo, double varOne, double varTwo) {
    if (valueOne == 1 && valueTwo == 3) {
      // watts and amps
      return varOne / varTwo;
    } else if (valueOne == 1 && valueTwo == 4) {
      // watts and ohms
      return Math.sqrt(varOne * varTwo);
    } else if (valueOne== 3 && valueTwo == 4) {
      // amps and ohms
      return varOne * varTwo;
    } else {
      System.out.print("\nThat was not a valid option\n");
      return 0.0;
    }
  }
  public static double calculateCurrent(int valueOne, int valueTwo, double varOne, double varTwo) {
    if (valueOne == 1 && valueTwo == 2) {
      // watts and volts
      return varOne / varTwo;
    } else if (valueOne == 1 && valueTwo == 4) {
      // watts and ohms
      return Math.sqrt(varOne / varTwo);
    } else if (valueOne == 2 && valueTwo == 4) {
      // volts and ohms
      return varOne / varTwo;
    } else {
      System.out.print("\nThat was not a valid option\n");
      return 0.0;
    }
  }
  public static double calculateResistance(int valueOne, int valueTwo, double varOne, double varTwo) {
    if (valueOne == 1 && valueTwo == 2) {
      // watts and volts
      return Math.pow(varTwo, 2) / varOne;
    } else if (valueOne == 1 && valueTwo == 3) {
      // watts and amps
      return varOne / Math.pow(varTwo, 2);
    } else if (valueOne == 2 && valueTwo == 3) {
      // volts and amps
      return varOne / varTwo;
    } else {
      System.out.print("\nThat was not a valid option\n");
      return 0.0;
    }
  }
  public static void values() {
    line();
    System.out.println("| P: Power               (Watts) = 1 |");
    System.out.println("| E: Electromotive force (Volts) = 2 |");
    System.out.println("| I: Intensity           (Amps)  = 3 |");
    System.out.println("| R: Resistance          (Ohms)  = 4 |");
    line();
    System.out.println("| Pick (1, 2, 3, or 4):              |");
    line();
    System.out.print("└─> ");
  }
  public static void line() {
    System.out.println("|------------------------------------|");
  }
}