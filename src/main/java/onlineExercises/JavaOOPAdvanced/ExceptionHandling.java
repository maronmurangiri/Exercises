package onlineExercises.JavaOOPAdvanced;

public class ExceptionHandling {
    public static void checkScore(double score){
        if (score>0 && score<=50.00){
            System.out.println("Average Score");
        } else if (score>50.00 && score<=100) {
            System.out.println("Very good score");
        }
        else {

            throw new ArithmeticException("Score is out of scale");

        }
    }

    public static void main(String[] args){
        checkScore(2.15);
        checkScore(50);
        checkScore(95);
        checkScore(100.01);
    }
}
