// 4.	How could you simplify this code to prevent cyclomatic complexity?
package maintainability;

public class Question04 {
    public String validatePerson(Person person, int pin) {
        if (isSystemUp) {
            if (person != null && person.getName().equals("")) {
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
    }
    
}
