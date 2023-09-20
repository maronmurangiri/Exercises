package LiveCodingSessions.July17th.Question1;

public class Tester {
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle("Toyota",2015);
        vehicle.accelerate();
        vehicle.brake();
        System.out.println(vehicle);

        Car car = new Car("Prado",2023,4);
        System.out.println();
        car.brake();
        car.accelerate();
        car.openDoors();
        System.out.println(car);

    }
}
