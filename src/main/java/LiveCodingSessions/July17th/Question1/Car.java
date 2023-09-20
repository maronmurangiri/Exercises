package LiveCodingSessions.July17th.Question1;

public class Car extends Vehicle {
    @Override
    public String toString() {
        return "Car{" +
                "numDoors=" + numDoors +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }

    int numDoors;

    public Car(String manufacturer, int year, int numOfDoors) {
        super(manufacturer, year);
        this.numDoors = numOfDoors;
    }

    public void openDoors(){
        System.out.println("Opening car doors");
    }
}

