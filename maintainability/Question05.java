// 5.	How do you avoid complext logical conditions?
package maintainability;

import java.util.Date;

public class Question05 {
    public boolean isDateExpired(Date date) {

        if (date != null && date.compareTo(new Date()) > 1) {
            return false;
        }
        
        return true;
        }
        
}
