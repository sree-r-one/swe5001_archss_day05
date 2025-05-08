// 2.	How could you rewrite this code for Single Responsibiility?

package maintainability;

import javax.swing.text.AbstractDocument.Content;

public class Question02 {

    void sendNotification(Content content, boolean isEmail) {
        if (isEmail) {
            // send email
        } else {
            // send SMS
        }
    }

}
