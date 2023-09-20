package LearningAsIWork.Cloneable;

//import jdk.incubator.vector.VectorOperators;

class Drinks{
    int color;
    int brand;
}
class Fanta implements Cloneable{
    int price;
    int flavour;
    Drinks drinks = new Drinks();

    public Object Clone() throws CloneNotSupportedException{
        Fanta fanta = (Fanta)super.clone();
        fanta.drinks = new Drinks();
        fanta.drinks.brand = drinks.brand;
        fanta.drinks.color = drinks.color;
        return fanta;
    }

}


public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
                Fanta fanta = new Fanta();
                fanta.flavour = 10;
                fanta.price = 20;
                fanta.drinks.color = 30;

                Fanta clonedFanta = (Fanta)fanta.Clone();
                fanta.price = 100;
                fanta.drinks.color = 2;
        System.out.println(fanta.drinks.color);
        System.out.println(clonedFanta.drinks.color);
    }
}
