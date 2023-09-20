package LiveCodingSessions.July17th.Question1;

public class Vehicle {
    public Vehicle(String manufacturer, int year) {
        this.manufacturer = manufacturer;
        this.year = year;
    }

    String manufacturer;
    int year;

    @Override
    public String toString() {
        return "Vehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }

    public void accelerate(){
        System.out.println("Vehicle accelerating");
    }
    public void brake(){
        System.out.println("Vehicle braking");
    }
}
