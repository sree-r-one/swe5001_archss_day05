// 3.	How can you rewrite the code to report any failure (or arithmetic exceptions) and throw illegal argument exception?

package maintainability;

public class Question03 {
    private double total;

    private double calculateDiscount(double discount) {
        return getTotal()  * discount / 100;
    }

    public double getTotal() {
        return total;
    }
    
}
