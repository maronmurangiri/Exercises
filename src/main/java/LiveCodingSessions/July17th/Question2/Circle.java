package LiveCodingSessions.July17th.Question2;

public class Circle implements Shape{
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {

        return (3.142*(radius*2));
    }

    @Override
    public void display() {
        System.out.println("The shape is a circle or radius: "+radius);
    }
}
