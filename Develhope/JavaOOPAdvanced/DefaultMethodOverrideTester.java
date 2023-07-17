package Develhope.JavaOOPAdvanced;

import java.util.Objects;

class Smartphone implements Cloneable{

    String brandName;
    String modelName;
    int batterymAh;

   SmartphonePrice producerPrice;
   SmartphonePrice retailPrice;

    @Override
    public String toString() {
        return "Smartphone{" +
                "brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", batterymAh=" + batterymAh +
                ", producerPrice=" + producerPrice +
                ", retailPrice=" + retailPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return batterymAh == that.batterymAh && Objects.equals(brandName, that.brandName) && Objects.equals(modelName, that.modelName) && Objects.equals(producerPrice, that.producerPrice) && Objects.equals(retailPrice, that.retailPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, modelName, batterymAh, producerPrice, retailPrice);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Smartphone clonedSmartphone = (Smartphone)super.clone();
        clonedSmartphone.producerPrice = producerPrice;
        clonedSmartphone.retailPrice = retailPrice;

        return clonedSmartphone;
    }

    public Smartphone(String brand, String model, int battery, SmartphonePrice producerP, SmartphonePrice retailP) {
        this.brandName = brand;
        this.modelName = model;
        this.batterymAh = battery;
        this.producerPrice = producerP;
        this.retailPrice = retailP;
    }
}


class SmartphonePrice implements Cloneable{
    String priceType;
    double priceInEuros;

    @Override
    public Object clone() throws CloneNotSupportedException {
        SmartphonePrice clonedSmartphonePrice = (SmartphonePrice) super.clone();
        return clonedSmartphonePrice;
    }

    @Override
    public String toString() {
        return "SmartphonePrice{" +
                "priceType='" + priceType + '\'' +
                ", priceInEuros=" + priceInEuros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartphonePrice that = (SmartphonePrice) o;
        return Double.compare(that.priceInEuros, priceInEuros) == 0 && Objects.equals(priceType, that.priceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceType, priceInEuros);
    }

    public SmartphonePrice(String priceType, double priceInEuros) {
        this.priceType = priceType;
        this.priceInEuros = priceInEuros;
    }
}

public class DefaultMethodOverrideTester {
    public static void main(String[] args){
        SmartphonePrice producer1 = new SmartphonePrice("Producer",20);
        SmartphonePrice producer2 = new SmartphonePrice("Producer",25);
        SmartphonePrice retail1 = new SmartphonePrice("Retail",30);
        SmartphonePrice retail2 = new SmartphonePrice("Retail",35);

        Smartphone smartphone1 = new Smartphone("Infinix","Zero 8",3000,producer1,retail1);
        System.out.println(smartphone1);

        Smartphone smartphone2 = new Smartphone("Oppo","Reno 8T",4800,producer2,retail2);
        System.out.println(smartphone2);

        if (smartphone1.equals(smartphone2)){
            System.out.println("smartphone " +smartphone1.brandName+" is equal to "+smartphone2.brandName);
        }
        else {
            System.out.println("smartphone " +smartphone1.brandName+" is not equal to smartphone "+smartphone2.brandName);
        }


        try {
            Smartphone newSmartPhone = (Smartphone) smartphone2.clone();
            System.out.println(newSmartPhone);

            if (smartphone2.equals(newSmartPhone)){
                System.out.println("smartphone " +smartphone2.brandName+" is equal to smartphone "+newSmartPhone.brandName);
            }
            else {
                System.out.println("smartphone " +smartphone2.brandName+" is not equal to smartphone "+newSmartPhone.brandName);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("\nError: Cloneable interface not implemented @ "+exception.getMessage());
        }


    }
}
