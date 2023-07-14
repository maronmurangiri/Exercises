package Develhope.JavaOOPAdvanced;

abstract class Vehicle{
    String type;
    int numberOfWheels;

    public void showVehicleDetails(){
        System.out.println("The type "+ type+" has "+numberOfWheels+" wheels");
    };

    abstract void doVehicleSound();
}

class Car extends Vehicle{
    int numberOfDoors;
    double carPrice;

    public Car(double price,int doors, int wheels) {
        this.numberOfDoors = doors;
        this.carPrice = price;
        this.numberOfWheels = wheels;
        this.type = "Car";

    }

    @Override
    public void showVehicleDetails(){
        super.showVehicleDetails();
        System.out.println(type +" Vehicle has "+numberOfDoors+ " doors");
    }

    @Override
    void doVehicleSound() {
        System.out.println(type+ " produces vooooooooooooooom sound");
    }
}

class Boat extends Vehicle{
    double maxKnotsSpeed;
    int boatKilosWeight;

    public Boat(double maxSpeed, int weight) {
        this.maxKnotsSpeed = maxSpeed;
        this.boatKilosWeight = weight;
        this.type = "Boat";
    }

    public String getBoatWeightAndSpeed(){
        return boatKilosWeight+" Kgs weight "+type+" vehicle thrives at a maximum speed of "+maxKnotsSpeed;
    }

    @Override
    void doVehicleSound() {
        System.out.println(type+" vehicle produces Boooooooaaaaaaaaaaaaaatttttttt sound");
    }


}

public class AbstractionTester {
    public static void main(String[] args){

        Car car = new Car(400_000,3,4);
        Boat boat = new Boat(70,500);

        car.showVehicleDetails();
        car.doVehicleSound();

        System.out.println(boat.getBoatWeightAndSpeed());
        boat.doVehicleSound();
        boat.showVehicleDetails();

    }
}
