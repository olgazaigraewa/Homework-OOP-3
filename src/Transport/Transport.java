package Transport;

import lombok.Getter;
import lombok.Setter;


import java.util.Objects;

@Getter
@Setter

public abstract class Transport {
    private String brand;
    private String model;
    private int year;
    private String country;
    private String color;
    private int maxSpeed;

    public Transport(String brand, String model, int year, String country, String color,int maxSpeed ) {
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
    }

    public void setColor(String color) {
        this.color = Objects.requireNonNullElse(color, "белый");
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = Math.max(maxSpeed, 0);
    }
    public abstract void refill();
    public abstract  void printInfo();


}

