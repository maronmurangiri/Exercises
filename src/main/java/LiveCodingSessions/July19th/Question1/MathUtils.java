package LiveCodingSessions.July19th.Question1;

public class MathUtils {
    int num1;
    int num2;

    public MathUtils(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add(){
        return  num1 + num2;
    }
    public int sub(){
        return  num1 - num2;
    }
    public int multiply(){
        return  num1 * num2;
    }

    public int modulo(int num1, int num2){
        return  num1%num2;
    }
}
