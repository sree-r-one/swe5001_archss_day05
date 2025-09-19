// 3.	How can you rewrite the code to report any failure (or arithmetic exceptions) and throw illegal argument exception?

/*
ANSWER: This code lacks proper error handling and validation. Issues and improvements:

PROBLEMS IDENTIFIED:
1. No validation for negative discount values
2. No handling of arithmetic exceptions (e.g., overflow)
3. No validation for extreme values that could cause calculation errors
4. Missing IllegalArgumentException for invalid inputs
5. No error reporting mechanism

IMPROVED VERSION with proper exception handling:

public class Question03 {
    private double total;

    private double calculateDiscount(double discount) throws IllegalArgumentException {
        // Input validation - throw IllegalArgumentException for invalid inputs
        if (discount < 0) {
            throw new IllegalArgumentException("Discount cannot be negative. Provided: " + discount);
        }
        if (discount > 100) {
            throw new IllegalArgumentException("Discount cannot exceed 100%. Provided: " + discount);
        }
        if (Double.isNaN(discount) || Double.isInfinite(discount)) {
            throw new IllegalArgumentException("Discount must be a valid number. Provided: " + discount);
        }
        
        double currentTotal = getTotal();
        if (currentTotal < 0) {
            throw new IllegalArgumentException("Total cannot be negative for discount calculation");
        }
        
        try {
            // Perform calculation with overflow protection
            double result = currentTotal * discount / 100;
            
            // Check for arithmetic overflow/underflow
            if (Double.isInfinite(result) || Double.isNaN(result)) {
                throw new ArithmeticException("Arithmetic overflow in discount calculation");
            }
            
            return result;
        } catch (ArithmeticException e) {
            // Report arithmetic failures
            System.err.println("Arithmetic error in discount calculation: " + e.getMessage());
            throw e; // Re-throw to caller
        }
    }

    public double getTotal() {
        return total;
    }
    
    // Additional method for safe total setting
    public void setTotal(double total) throws IllegalArgumentException {
        if (total < 0) {
            throw new IllegalArgumentException("Total cannot be negative");
        }
        if (Double.isNaN(total) || Double.isInfinite(total)) {
            throw new IllegalArgumentException("Total must be a valid number");
        }
        this.total = total;
    }
}

USAGE EXAMPLE with proper exception handling:
try {
    Question03 calculator = new Question03();
    calculator.setTotal(100.0);
    double discount = calculator.calculateDiscount(15.5);
    System.out.println("Discount: " + discount);
} catch (IllegalArgumentException e) {
    System.err.println("Invalid argument: " + e.getMessage());
} catch (ArithmeticException e) {
    System.err.println("Calculation error: " + e.getMessage());
}
*/

package maintainability;

public class Question03 {
    private double total;

    // PROBLEM: No input validation or exception handling
    // ISSUE 1: Negative discount values not validated
    // ISSUE 2: No check for extreme values (>100%, NaN, Infinity)
    // ISSUE 3: No arithmetic exception handling
    // ISSUE 4: No IllegalArgumentException thrown for invalid inputs
    // IMPROVEMENT: Add comprehensive validation and exception handling (see
    // detailed solution above)
    private double calculateDiscount(double discount) {
        // MISSING: if (discount < 0 || discount > 100) throw new
        // IllegalArgumentException(...)
        // MISSING: if (Double.isNaN(discount)) throw new IllegalArgumentException(...)
        // MISSING: try-catch for arithmetic exceptions
        return getTotal() * discount / 100;
    }

    // PROBLEM: No validation when getting total
    // IMPROVEMENT: Consider validation to ensure total is valid before calculations
    public double getTotal() {
        return total;
    }

}
