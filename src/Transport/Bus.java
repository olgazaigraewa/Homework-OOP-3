package Transport;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Bus extends Transport {
    private float priceOfTheTrip;
    private int routeNumber;
    private int seatsCount;
    private String brand;
    private String model;
    private int year;
    private String country;
    private String color;
    private int maxSpeed;
    private String fuelType;

    public Bus(String brand, String model, int year, String country, String color, int maxSpeed,
               float priceOfTheTrip, int routeNumber, int seatsCount, String fuelType) {
        super(brand, model, year, country, color, maxSpeed);
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
        this.priceOfTheTrip = Math.max(priceOfTheTrip, 0);
        this.routeNumber = Math.max(routeNumber, 0);
        this.seatsCount = Math.max(seatsCount, 0);
        this.fuelType = Objects.requireNonNullElse(fuelType, "default");
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = Objects.requireNonNullElse(fuelType, "default");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
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

    public float getPriceOfTheTrip() {
        return priceOfTheTrip;
    }

    public void setPriceOfTheTrip(float priceOfTheTrip) {
        this.priceOfTheTrip = Math.max(priceOfTheTrip, 0);
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = Math.max(routeNumber, 0);
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = Math.max(seatsCount, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus)) return false;
        Bus bus = (Bus) o;
        return getBrand().equals(bus.getBrand()) && getModel().equals(bus.getModel()) && getFuelType().equals(bus.getFuelType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getFuelType());
    }

    @Override
    public void refill() {
        if (getFuelType().equals("бензин") && (!getFuelType().equals("дизель"))) {
            System.out.println("заправить автобус " + getBrand() + " " + getModel() + " бензином");
        } else if (!getFuelType().equals("бензин") && (getFuelType().equals("дизель"))) {
            System.out.println("заправить автобус " + getBrand() + " " + getModel() + " дизельным топливом");
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Автобус - " + getBrand() + " " + getModel() +
                ", год выпуска - " + getYear() +
                ", сборка -  " + getCountry() +
                ",  цвет - " + getColor() +
                ", максимальная скорость - " + getMaxSpeed()+
                ", стоимость проезда - " + getPriceOfTheTrip() +
                ", номер маршрута - " + getRouteNumber() +
                ", количество мест - " + getSeatsCount() +
                ", тип топлива - " + getFuelType());


    }

}



