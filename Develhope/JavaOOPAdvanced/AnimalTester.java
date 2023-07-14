package Develhope.JavaOOPAdvanced;

class Animal{
    String animalName;

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public void animalSound(){
        System.out.println("Normal Animal: Roarr!");
    }
    public void animalSound(String intensity){

       if (intensity.equalsIgnoreCase("high")) {
           System.out.println("High intensity animal: Roarrrrrrrr!");
       }
       else if (intensity.equalsIgnoreCase("low")) {
           System.out.println("Low intensity animal:  Roar");
       }
       else {
           System.out.println("Cannot reproduce it properly");
       }
    }


}

public class AnimalTester {
    public static void main(String[] args) {
        Animal animal = new Animal("Lion");
                animal.animalSound();
                animal.animalSound("High");
                animal.animalSound("Low");
    }
}
