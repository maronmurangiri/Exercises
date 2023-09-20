package LiveCodingSessions.July17th.Question2;

public class Tester {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(20.5,20.2);
        rectangle.display();
        System.out.println("The area of this shape is: "+rectangle.calculateArea());
        System.out.println();

        Circle circle = new Circle(2.0);
        circle.display();
        System.out.println("The area of this shape is: "+circle.calculateArea());
    }
}
