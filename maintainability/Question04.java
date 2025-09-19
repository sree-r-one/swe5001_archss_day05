// 4.	How could you simplify this code to prevent cyclomatic complexity?

/*
ANSWER: This code has high cyclomatic complexity due to nested if statements. 

PROBLEMS IDENTIFIED:
1. Nested if-else statements create complex control flow
2. Multiple exit points make code hard to follow
3. High cyclomatic complexity (complexity = 4)
4. Difficult to test all code paths
5. Hard to maintain and modify

CYCLOMATIC COMPLEXITY CALCULATION:
- Base complexity: 1
- if (isSystemUp): +1
- if (person != null && person.getName().equals("")): +1  
- if (person.getPin() != pin): +1
- Total: 4 (considered medium complexity)

IMPROVED VERSIONS:

// Option 1: Guard Clauses (Early Returns)
public String validatePersonImproved(Person person, int pin) {
    // Guard clause for system status
    if (!isSystemUp) {
        return "System is Down";
    }
    
    // Guard clause for null person
    if (person == null) {
        return "Invalid name";
    }
    
    // Guard clause for empty name
    if (person.getName().equals("")) {
        return "Invalid name"; 
    }
    
    // Guard clause for invalid pin
    if (person.getPin() != pin) {
        return "Invalid Pin";
    }
    
    // Happy path
    return "Person validation successful";
}

// Option 2: Extract validation methods
public String validatePersonWithMethods(Person person, int pin) {
    if (!isSystemUp()) return "System is Down";
    if (!isValidPerson(person)) return "Invalid name";
    if (!isValidPin(person, pin)) return "Invalid Pin";
    return "Person validation successful";
}

private boolean isSystemUp() { return isSystemUp; }
private boolean isValidPerson(Person person) { 
    return person != null && !person.getName().equals(""); 
}
private boolean isValidPin(Person person, int pin) { 
    return person.getPin() == pin; 
}

BENEFITS:
- Reduced cyclomatic complexity from 4 to 1
- Clearer code flow with early returns
- Easier to test individual conditions
- Better maintainability and readability
- Single responsibility for each validation
*/

package maintainability;

public class Question04 {
    // MISSING: This field should be declared
    private boolean isSystemUp;

    // HIGH CYCLOMATIC COMPLEXITY: This method has complexity of 4
    // PROBLEM 1: Nested if-else statements create complex control flow
    // PROBLEM 2: Multiple conditions checked in sequence rather than early returns
    // PROBLEM 3: Hard to test all code paths
    // IMPROVEMENT: Use guard clauses (early returns) to reduce nesting
    public String validatePerson(Person person, int pin) {
        if (isSystemUp) {
            // NESTED COMPLEXITY: Multiple conditions nested inside system check
            // BETTER: if (!isSystemUp) return "System is Down"; (guard clause)
            if (person != null && person.getName().equals("")) {
                // LOGIC ERROR: This condition seems wrong - empty name should be invalid
                // LIKELY MEANT: !person.getName().equals("") or person.getName().isEmpty()
                if (person.getPin() != pin) {
                    return "Invalid Pin";
                }
                return "Person validation successful";
            } else {
                return "Invalid name";
            }
        } else {
            return "System is Down";
        }
        // IMPROVEMENT: Refactor to:
        // if (!isSystemUp) return "System is Down";
        // if (person == null || person.getName().isEmpty()) return "Invalid name";
        // if (person.getPin() != pin) return "Invalid Pin";
        // return "Person validation successful";
    }

}

// MISSING: Person class definition needed
class Person {
    private String name;
    private int pin;

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }
}
