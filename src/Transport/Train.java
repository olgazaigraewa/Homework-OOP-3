package Transport;

import lombok.Getter;

import java.util.Objects;
@Getter

public class Train extends Transport {
    private final String brand;
    private final String model;
    private final int year;
    private final String country;
    private final String color;
    private final int maxSpeed;
    private float priceOfTheTrip;
    private float timeOfTheTrip;
    private String departureStation;
    private String finalStop;
    private int numberOfWagons;
    private String fuelType;

    public Train(String brand, String model, int year, String country, String color, int maxSpeed, float priceOfTheTrip,
                 float timeOfTheTrip, String departureStation, String finalStop, int numberOfWagons, String fuelType) {
        super(brand, model, year, country, color, maxSpeed );
        this.brand = Objects.requireNonNullElse(brand, "default");
        this.model = Objects.requireNonNullElse(model, "default");
        if (year <= 0) {
            this.year = 2000;
        } else {
            this.year = year;
        }
        this.country = Objects.requireNonNullElse(country, "default");
        this.color = Objects.requireNonNullElse(color, "белый");
        this.maxSpeed = Math.max(maxSpeed, 0);
        this.timeOfTheTrip = Math.max(timeOfTheTrip, 0);
        this.priceOfTheTrip = Math.max(priceOfTheTrip, 0);
        this.departureStation = Objects.requireNonNullElse(departureStation, "default");
        this.finalStop = Objects.requireNonNullElse(finalStop, "default");
        this.numberOfWagons = Math.max(numberOfWagons, 0);
        this.fuelType = Objects.requireNonNullElse(fuelType, "default");
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }

    public float getPriceOfTheTrip() {
        return priceOfTheTrip;
    }

    public void setPriceOfTheTrip(float priceOfTheTrip) {
        this.priceOfTheTrip = Math.max(priceOfTheTrip, 0);
    }

    public float getTimeOfTheTrip() {
        return timeOfTheTrip;
    }

    public void setTimeOfTheTrip(float timeOfTheTrip) {
        this.timeOfTheTrip = Math.max(timeOfTheTrip, 0);
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = Objects.requireNonNullElse(departureStation, "default");
    }

    public String getFinalStop() {
        return finalStop;
    }

    public void setFinalStop(String finalStop) {
        this.finalStop = Objects.requireNonNullElse(finalStop, "default");
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    public void setNumberOfWagons(int numberOfWagons) {
        this.numberOfWagons = Math.max(numberOfWagons, 0);

    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = Objects.requireNonNullElse(fuelType, "default");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        Train train = (Train) o;
        return getFuelType().equals(train.getFuelType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFuelType());
    }

    @Override
    public void refill() {
        System.out.println( " заправить поезд " +  getBrand() + getModel() +" дизельным топливом");
    }

    @Override
    public void printInfo() {
        System.out.println( "Поезд - " + getBrand() + " " + getModel() +
                ", год выпуска - " + getYear() +
                ", сборка -  " + getCountry() +
                ",  цвет - " + getColor() +
                ",  скорость передвижения " + getMaxSpeed() +
                ", цена поездки - " + getPriceOfTheTrip() +
                ", время поездки - " + getTimeOfTheTrip() + " часов " +
                ",станция отправления - " + getDepartureStation() +
                ", конечная остановка - " + getFinalStop() +
                ", количество вагонов - " + getNumberOfWagons() +
                ", тип топлива - " + getFuelType());
    }


}
