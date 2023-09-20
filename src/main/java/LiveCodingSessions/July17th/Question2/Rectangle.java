package LiveCodingSessions.July17th.Question2;

public class Rectangle implements Shape{
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width*height;
    }

    @Override
    public void display() {
        System.out.println("The shape is a rectangle of width "+width+" and height: "+height);
    }
}
