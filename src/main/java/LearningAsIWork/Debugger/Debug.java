package LearningAsIWork.Debugger;

import org.junit.jupiter.api.Assertions;

public class Debug {
    public static void main(String[] args){
        Circle circle = new Circle();
       Assertions.assertEquals(153.93804002589985,circle.CalculateArea(7));
    }
}

class Circle{
    public double CalculateArea(int radius){
         int area =22/7*radius;
        return area;
    }
}