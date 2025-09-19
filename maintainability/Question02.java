// 2.	How could you rewrite this code for Single Responsibiility?

/*
ANSWER: This code violates the Single Responsibility Principle (SRP) because:

PROBLEM: The sendNotification method has multiple responsibilities:
1. Deciding which notification type to send (routing logic)
2. Handling email notifications
3. Handling SMS notifications

SRP VIOLATION: A class should have only ONE reason to change, but this class would need 
to change if:
- Email sending logic changes
- SMS sending logic changes  
- New notification types are added
- Routing logic changes

IMPROVED DESIGN using SRP:

// 1. Abstract notification interface
interface NotificationSender {
    void send(Content content);
}

// 2. Separate classes for each notification type
class EmailNotificationSender implements NotificationSender {
    public void send(Content content) {
        // send email logic
    }
}

class SMSNotificationSender implements NotificationSender {
    public void send(Content content) {
        // send SMS logic
    }
}

// 3. Factory or Strategy pattern for routing
class NotificationService {
    private NotificationSender emailSender = new EmailNotificationSender();
    private NotificationSender smsSender = new SMSNotificationSender();
    
    public void sendNotification(Content content, NotificationType type) {
        NotificationSender sender = getSender(type);
        sender.send(content);
    }
    
    private NotificationSender getSender(NotificationType type) {
        return type == NotificationType.EMAIL ? emailSender : smsSender;
    }
}

BENEFITS:
- Each class has a single, well-defined responsibility
- Easy to add new notification types without modifying existing code
- Better testability (can test each sender independently)
- Follows Open/Closed Principle (open for extension, closed for modification)
*/

package maintainability;

import javax.swing.text.AbstractDocument.Content;

public class Question02 {

    // SRP VIOLATION: This method has multiple responsibilities
    // RESPONSIBILITY 1: Deciding which notification type to use (routing logic)
    // RESPONSIBILITY 2: Handling email sending
    // RESPONSIBILITY 3: Handling SMS sending
    // PROBLEM: Any change to email logic, SMS logic, or routing logic requires
    // modifying this method
    void sendNotification(Content content, boolean isEmail) {
        if (isEmail) {
            // RESPONSIBILITY 2: Email sending logic
            // ISSUE: Email implementation details mixed with routing logic
            // IMPROVEMENT: Extract to separate EmailNotificationSender class
            // send email
        } else {
            // RESPONSIBILITY 3: SMS sending logic
            // ISSUE: SMS implementation details mixed with routing logic
            // IMPROVEMENT: Extract to separate SMSNotificationSender class
            // send SMS
        }
        // MISSING: What if we need to add Push notifications, Slack notifications,
        // etc.?
        // This method would keep growing and violating SRP further
    }

}
