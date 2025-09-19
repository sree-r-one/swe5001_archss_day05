// 5.	How do you avoid complext logical conditions?

/*
ANSWER: This code has complex logical conditions that can be simplified.

PROBLEMS IDENTIFIED:
1. Complex condition with multiple checks in one line
2. Logic error in date comparison (using compareTo incorrectly)
3. Magic number '1' without explanation
4. Unnecessary null check combined with comparison
5. Confusing return logic (could be simplified)

ISSUES IN CURRENT CODE:
- date.compareTo(new Date()) > 1 is WRONG
  * compareTo returns -1, 0, or 1 (not arbitrary numbers)
  * Should be date.compareTo(new Date()) > 0 for "date is after now"
- Complex condition combining null check and comparison
- Inverted logic makes it hard to understand

IMPROVED VERSIONS:

// Option 1: Extract method with clear naming
public boolean isDateExpired(Date date) {
    if (isNullDate(date)) {
        return true; // Null dates are considered expired
    }
    
    return isDateInPast(date);
}

private boolean isNullDate(Date date) {
    return date == null;
}

private boolean isDateInPast(Date date) {
    return date.compareTo(new Date()) < 0; // date is before now
}

// Option 2: Modern approach with java.time
import java.time.LocalDate;

public boolean isDateExpired(LocalDate date) {
    if (date == null) {
        return true;
    }
    
    return date.isBefore(LocalDate.now());
}

// Option 3: Single expression with proper logic
public boolean isDateExpired(Date date) {
    return date == null || date.before(new Date());
}

BENEFITS:
- Clear, readable method names
- Separated concerns (null check vs date comparison)
- Correct date comparison logic
- Modern API usage (java.time)
- Single responsibility per method
*/

package maintainability;

import java.util.Date;

public class Question05 {
    // COMPLEX LOGICAL CONDITION: Multiple issues in this method
    // PROBLEM 1: Complex condition combining null check and comparison
    // PROBLEM 2: Logic error - compareTo() returns -1, 0, or 1, not arbitrary
    // numbers
    // PROBLEM 3: Magic number '1' - should be '0' for "greater than current date"
    // PROBLEM 4: Confusing logic flow with unnecessary complexity
    public boolean isDateExpired(Date date) {

        // COMPLEX CONDITION: Combines null check with incorrect date comparison
        // ISSUE: date.compareTo(new Date()) > 1 is WRONG
        // FIX: Should be date.compareTo(new Date()) > 0 (date is after now)
        // BETTER: Extract to separate methods for clarity
        if (date != null && date.compareTo(new Date()) > 1) {
            return false;
        }

        // UNNECESSARY: This could be simplified to single expression
        // IMPROVEMENT: return date == null || date.before(new Date());
        return true;
    }

}
