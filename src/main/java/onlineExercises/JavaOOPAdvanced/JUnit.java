package onlineExercises.JavaOOPAdvanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit {
    public static int subtraction(int minuend, int subtrahend){
        return minuend-subtrahend;

    }
    public static int multiplication(int multiplier, int multiplicand ){
        return multiplicand * multiplier;

    }


}


 class JUnitTest {

    @Test
    void subtraction() {
        assertEquals(4,JUnit.subtraction(12,8),"Subtraction Test failed, Kindly debug the method");
        System.out.println("Subtraction test successful");
    }

    @Test
    void multiplication() {
        assertEquals(15,JUnit.multiplication(5,3),"Multiplication Test failed, Kindly debug the method");
        System.out.println("Multiplication test successful");
    }
}
