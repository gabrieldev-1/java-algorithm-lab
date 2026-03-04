package exercices;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The BotDivisor class provides utility methods to perform division operations
 * while handling potential arithmetic and input errors gracefully.
 */
public class BotDivisor {

    /**
     * Performs division between two integers.
     * * @param dividend The number to be divided.
     * @param divisor  The number to divide by.
     * @return The result of the division.
     * @throws ArithmeticException If the divisor is zero.
     */
    public static int calculate(int dividend, int divisor) {
        try {
            return dividend / divisor;
        } catch (ArithmeticException err) {
            // Relaying the exception with a clear message while maintaining context
            throw new ArithmeticException("Mathematical error: Division by zero is not allowed. Details: " + err.getMessage());
        }
    }

    /**
     * Main entry point of the program.
     * Handles user input and manages exceptions in a controlled environment.
     * * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Using try-with-resources to ensure the scanner is automatically closed
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Enter the dividend: ");
            int dividend = scanner.nextInt();

            System.out.print("Enter the divisor: ");
            int divisor = scanner.nextInt();

            // Perform calculation and output result
            System.out.println("The result is: " + calculate(dividend, divisor));
        
        } catch (InputMismatchException err) {
            // Specific catch for non-integer inputs
            System.err.println("ERROR: You must enter valid integer numbers.");

        } catch (ArithmeticException err) {
            // Catches the exception thrown by the calculate() method
            System.err.println(err.getMessage());

        } catch (Exception err) {
            // Catch-all block for any unforeseen errors
            System.err.println("An unexpected error occurred: " + err.getMessage());

        } finally {
            // The finally block executes regardless of success or failure
            System.out.println("--- Bot operation finished ---");
            
        }
    }
}