// 7.	How could you apply SRP (Single Responsibiliity Principle) to re-organize the class to only have methods hat are specific to the class?
package maintainability;

import java.util.Date;

public class Question07 {
    String id;
    Date orderDate;

    String getOrderId() {
        return this.id;
    }

    Date getOrderDate() {
        return this.orderDate;
    }

    void sendOrderNotification() {

    }

    void calculateDiscount() {

    }
}
