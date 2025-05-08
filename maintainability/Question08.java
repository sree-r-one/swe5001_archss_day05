// 8.	Change the following code to comply to Open/Closed Principle?

public class CalculateService {

    public double calculateRectangleArea(double width, double height) {
        return width * height;

    }
    
    public double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
    
}

public class Circle {
    private double radius;
    public double area;
    
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

class Rectangle {
    private double width;
    private double height;
    public double area;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

public static void main (String[] args) {
    Rectangle rectangle1 = new Rectangle(5.5 , 8);
    Circle circle1 = new Circle(4);
 
    CalculateService calculateService = new CalculateService();
    rectangle1.area = calculateService.calculateRectangleArea(rectangle1.getWidth(), rectangle1.getHeight());
    circle1.area = calculateService.calculateCircleArea(circle1.getRadius());
}
