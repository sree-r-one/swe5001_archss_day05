// 7.	How could you apply SRP (Single Responsibiliity Principle) to re-organize the class to only have methods hat are specific to the class?

/*
ANSWER: This class violates SRP by mixing order data management with business operations.

CURRENT CLASS RESPONSIBILITIES:
1. Order data storage (id, orderDate)
2. Order data access (getters)
3. Notification handling (sendOrderNotification)
4. Business logic (calculateDiscount)

SRP VIOLATION: This class has multiple reasons to change:
- Order data structure changes
- Notification system changes  
- Discount calculation logic changes
- New business rules

IMPROVED DESIGN following SRP:

// 1. Order class - Only handles order data
public class Order {
    private String id;
    private Date orderDate;
    
    public Order(String id, Date orderDate) {
        this.id = id;
        this.orderDate = orderDate;
    }
    
    public String getOrderId() { return this.id; }
    public Date getOrderDate() { return this.orderDate; }
}

// 2. OrderNotificationService - Only handles notifications
public class OrderNotificationService {
    public void sendOrderNotification(Order order) {
        // Notification logic here
        System.out.println("Sending notification for order: " + order.getOrderId());
    }
}

// 3. DiscountCalculator - Only handles discount calculations
public class DiscountCalculator {
    public double calculateDiscount(Order order, double discountRate) {
        // Discount calculation logic here
        return 0.0; // Implementation here
    }
}

// 4. OrderService - Coordinates operations (if needed)
public class OrderService {
    private OrderNotificationService notificationService;
    private DiscountCalculator discountCalculator;
    
    public OrderService() {
        this.notificationService = new OrderNotificationService();
        this.discountCalculator = new DiscountCalculator();
    }
    
    public void processOrder(Order order) {
        notificationService.sendOrderNotification(order);
        // Other order processing logic
    }
}

BENEFITS:
- Each class has a single, well-defined responsibility
- Changes to notification logic don't affect Order class
- Changes to discount logic don't affect other components
- Better testability (can test each component independently)
- Easier to maintain and extend
*/

package maintainability;

import java.util.Date;

// SRP VIOLATION: This class has too many responsibilities
// RESPONSIBILITY 1: Order data storage and access
// RESPONSIBILITY 2: Notification handling  
// RESPONSIBILITY 3: Business logic (discount calculation)
// PROBLEM: Changes to any of these areas require modifying this class
public class Question07 {
    // APPROPRIATE: Order data belongs in Order class
    String id;
    Date orderDate;

    // APPROPRIATE: Data access methods belong in Order class
    String getOrderId() {
        return this.id;
    }

    Date getOrderDate() {
        return this.orderDate;
    }

    // SRP VIOLATION: Notification logic doesn't belong in Order class
    // ISSUE: Changes to notification system affect Order class
    // IMPROVEMENT: Extract to OrderNotificationService class
    void sendOrderNotification() {
        // This should be in a separate NotificationService class
    }

    // SRP VIOLATION: Business logic doesn't belong in Order class
    // ISSUE: Changes to discount rules affect Order class
    // IMPROVEMENT: Extract to DiscountCalculator class
    void calculateDiscount() {
        // This should be in a separate DiscountCalculator class
    }
}
