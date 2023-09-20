package onlineExercises.JavaOOPAdvanced;

 class Shape{
    String shapeName;
    int numberOfEdges;

    public Shape() {
        System.out.println("Undefined shape Object created");
        shapeName = "Undefined";
    }
    public Shape(double radius){
        System.out.println("Circle shape Object successfully created");
        shapeName = "Circle";

    }
    public Shape(int edges, double edgeLength ){
        System.out.println("Square shape Object successfully created");
        shapeName = "Square";
        numberOfEdges = edges;

    }
    public Shape(int edges, double e1, double e2){
        System.out.println("Rectangle shape Object successfully created");
        shapeName = "Rectangle";
        numberOfEdges = edges;

    }

    public Shape(int edges, double e1, double e2, double e3){
        System.out.println("Triangle shape Object successfully created");
        shapeName = "Triangle";
        numberOfEdges = edges;

    }

     public String getShapeName() {
         return shapeName;
     }

     public int getNumberOfEdges() {
         return numberOfEdges;
     }

     public String getShapeDetails(){
        return getShapeName() +" shape has "+getNumberOfEdges()+ " edges";
    }
}

public class ShapeTester{
    public static void main(String[] args){
        Shape shape1 = new Shape();
        String shape1Details = shape1.getShapeDetails();
        System.out.println(shape1Details);

        Shape shape2 = new Shape(7.5);
        String shape2Details = shape2.getShapeDetails();
        System.out.println(shape2Details);

        Shape shape3 = new Shape(4,12.4);
        String shape3Details = shape3.getShapeDetails();
        System.out.println(shape3Details);

        Shape shape4 = new Shape(4,15.5,6.4);
        String shape4Details = shape4.getShapeDetails();
        System.out.println(shape4Details);

        Shape shape5 = new Shape(3,3.5,4.5,8.2);
        String shape5Details = shape5.getShapeDetails();
        System.out.println(shape5Details);

    }
}
