package LearningAsIWork.Cloneable;

class Meal{
    int quality;
    int quantity;
}
class Beef implements Cloneable{
    int taste;
    int proteinQ;
    Meal meal = new Meal();

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

}
public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Beef beef = new Beef();
        beef.taste = 50;
        beef.proteinQ =10;
        beef.meal.quality = 100;
        beef.meal.quantity = 200;


        Beef clonedBeef = (Beef)beef.clone();
        clonedBeef.taste =15;
        clonedBeef.meal.quantity =30;
        System.out.println(beef.meal.quantity);
        System.out.println(clonedBeef.meal.quantity);

    }

}
