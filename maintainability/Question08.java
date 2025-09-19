// 8.	Change the following code to comply to Open/Closed Principle?

/*
ANSWER: This code violates the Open/Closed Principle (OCP) because adding new shapes requires modifying CalculateService.

CURRENT PROBLEMS:
1. CalculateService must be modified for each new shape type
2. Tight coupling between service and shape-specific calculations
3. No abstraction for area calculation behavior
4. Violates OCP: "Open for extension, closed for modification"

IMPROVED DESIGN following OCP:

// 1. Abstract interface for area calculation
interface Shape {
    double calculateArea();
}

// 2. Each shape implements its own area calculation
class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    
    public double getRadius() { return radius; }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

// 3. Service uses abstraction, doesn't need modification for new shapes
class CalculateService {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}

// 4. Usage example
public static void main(String[] args) {
    Rectangle rectangle1 = new Rectangle(5.5, 8);
    Circle circle1 = new Circle(4);
    
    CalculateService calculateService = new CalculateService();
    
    // Polymorphic calls - no need to modify service for new shapes
    double rectangleArea = calculateService.calculateArea(rectangle1);
    double circleArea = calculateService.calculateArea(circle1);
    
    System.out.println("Rectangle area: " + rectangleArea);
    System.out.println("Circle area: " + circleArea);
}

BENEFITS:
- Adding new shapes (Triangle, Pentagon, etc.) requires NO changes to existing code
- CalculateService is closed for modification but open for extension
- Better separation of concerns
- Follows polymorphism principles
- Easier to test and maintain
*/

package maintainability;

// OCP VIOLATION: Adding new shapes requires modifying this class
// PROBLEM: Must add new methods for each shape type (Triangle, Pentagon, etc.)
// IMPROVEMENT: Use polymorphism - each shape calculates its own area
class CalculateService {

    // VIOLATION: Method specific to Rectangle - breaks OCP
    // ISSUE: Adding Triangle would require adding calculateTriangleArea()
    // BETTER: Single calculateArea(Shape shape) method using polymorphism
    public double calculateRectangleArea(double width, double height) {
        return width * height;

    }

    // VIOLATION: Method specific to Circle - breaks OCP
    // ISSUE: Each new shape type needs a new method here
    // BETTER: Let each shape implement its own calculateArea() method
    public double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

}

// MISSING BEHAVIOR: Should implement Shape interface with calculateArea()
// method
class Circle {
    private double radius;
    public double area;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

// MISSING BEHAVIOR: Should implement Shape interface with calculateArea()
// method
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

class Question08 {
    // OCP VIOLATION: Client code must know specific calculation methods
    // PROBLEM: Adding new shapes requires changing this main method
    // IMPROVEMENT: Use polymorphic calculateArea() calls
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(5.5, 8);
        Circle circle1 = new Circle(4);

        CalculateService calculateService = new CalculateService();
        // TIGHT COUPLING: Must call shape-specific methods
        // BETTER: calculateService.calculateArea(rectangle1)
        rectangle1.area = calculateService.calculateRectangleArea(rectangle1.getWidth(), rectangle1.getHeight());
        circle1.area = calculateService.calculateCircleArea(circle1.getRadius());
    }
}
