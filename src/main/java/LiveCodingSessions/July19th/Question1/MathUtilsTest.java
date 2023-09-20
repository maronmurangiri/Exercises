package LiveCodingSessions.July19th.Question1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void add() {
        MathUtils mathUtils = new MathUtils(40,20);
        int result = mathUtils.add();
        assertEquals(60,result,"Add Test Failed, Kindly debug");
        System.out.println("Add test passed successfully");
    }

    @Test
    void sub() {
        MathUtils mathUtils = new MathUtils(40,20);
        int result = mathUtils.sub();
        assertEquals(20,result,"Sub Test Failed, Kindly debug");
        System.out.println("Sub test passed successfully");
    }

    @Test
    void multiply() {
        MathUtils mathUtils = new MathUtils(4,2);
        int result = mathUtils.multiply();
        assertEquals(8,result,"Multiply Test Failed, Kindly debug");
        System.out.println("Multiply test passed successfully");
    }

    @Test
    void modulo() {
        MathUtils mathUtils = new MathUtils(9,0);
        //int result = mathUtils.modulo();
        assertThrows(ArithmeticException.class,()->mathUtils.modulo(20,0),"Test Failed,No arithmetic error thrown, Kindly debug");
        assertEquals(1,mathUtils.modulo(9,2),"Modulo Test Failed, Kindly debug");
        System.out.println("Modullo test passed successfully");
    }
}