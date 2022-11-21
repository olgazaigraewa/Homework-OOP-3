package Transport;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class Car extends Transport {
    private String brand;
    private String model;
    private int year;
    private String country;
    private String color;
    private int maxSpeed;
    private double engineVolume;
    private String transmission;
    private String typeOfBody;
    private String regNumber;
    private int seatsCount;
    private boolean summerTires;
    public Key key;
    private Insurance insurance;
    private String fuelType;


    public Car(String brand, String model, int year, String country, String color, int maxSpeed,
               double engineVolume, String transmission, String typeOfBody, String regNumber, int seatsCount,
               boolean summerTires,  Key key, Insurance insurance, String fuelType ) {
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
        if (engineVolume == 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        this.transmission  = Objects.requireNonNullElse(transmission, "АКПП");
        this.typeOfBody =  Objects.requireNonNullElse(typeOfBody, "седан");
        this.regNumber = Objects.requireNonNullElse(regNumber, "x000xx000");
        this.seatsCount =  Objects.requireNonNullElse(seatsCount, 5);
        this.summerTires = Objects.requireNonNullElse(summerTires, false);
        this.fuelType = Objects.requireNonNullElse(fuelType, "default");
        this.key = Objects.requireNonNullElseGet(null, Key::new);
        this.insurance = Objects.requireNonNullElseGet(insurance, () -> new Insurance());

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

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public boolean isSummerTires() {
        return summerTires;
    }

    public Key getKey() {
        return key;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setTransmission(String transmission) {
        this.transmission = Objects.requireNonNullElse(transmission, "АКПП");
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = Objects.requireNonNullElse(regNumber, "x000xx000");
    }

    public void isSummerTires(boolean summerTires) {
        this.summerTires = Objects.requireNonNullElse(summerTires, false);
    }

    public void setTypeOfBody(String typeOfBody) {
        this.typeOfBody = Objects.requireNonNullElse(typeOfBody, "седан");
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = Objects.requireNonNullElse(seatsCount, 5);
    }

    public void setFuelType(String fuelType) {
        this.fuelType = Objects.requireNonNullElse(fuelType, "default");
    }

    public void changeTires() {
        summerTires = !summerTires;
    }

    public void setKey(Key key) {
        this.key = Objects.requireNonNullElseGet(null, Key::new);
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = Objects.requireNonNullElseGet(insurance, () -> new Insurance());
    }

    public boolean isCorrectRegNumber() {
        if (regNumber.length() != 9) {
            return false;
        }
        char[] chars = regNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) && !Character.isAlphabetic(chars[4]) && !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3])
                && Character.isDigit(chars[6]) && Character.isDigit(chars[7]) && Character.isDigit(chars[8]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getFuelType().equals(car.getFuelType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFuelType());
    }

    @Override
    public void refill() {
        if (getFuelType().equals("бензин")&&(!getFuelType().equals("дизель")) && (!getFuelType().equals("электрокар"))) {
            System.out.println("заправить авто " + getBrand() + getModel() +  " бензином");
        }
        else if ((getFuelType().equals("дизель")&&!getFuelType().equals(" бензин"))&&(!getFuelType().equals("электрокар"))){
            System.out.println( "заправить авто " + getBrand() + getModel() + " дизельным топливом");
        } else {
            System.out.println("заправить авто " + getBrand() + getModel() + " зарядить авто на специальных электропарковках");
        }

    }

    public static class Key {
        private boolean remoteRunEngine;
        private boolean keylessAccess;

        public Key(boolean remoteRunEngine, boolean keylessAccess) {
            this.remoteRunEngine = remoteRunEngine;
            this.keylessAccess = keylessAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteRunEngine() {
            return remoteRunEngine;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }

        public void isRemoteRunEngine(boolean remoteRunEngine) {
            this.remoteRunEngine = remoteRunEngine;
        }

        public void isKeylessAccess(boolean keylessAccess) {
            this.keylessAccess = keylessAccess;
        }
    }

    public static class Insurance {
        private LocalDate expireDate;
        private double cost;
        private String number;

        public Insurance(LocalDate expireDate, double cost, String number) {
            this.expireDate = Objects.requireNonNullElseGet(expireDate, () -> LocalDate.now().plusDays(365));
            this.cost = Objects.requireNonNullElse(cost, 10_000.00);
            this.number = Objects.requireNonNullElse(number, "123456789");
        }
        public Insurance (){
            this (null, 10_000, null);
        }

        public LocalDate getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(LocalDate expireDate) {
            this.expireDate = Objects.requireNonNullElseGet(expireDate, () -> LocalDate.now().plusDays(365));
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }
        public void checkExpireDate() {
            if (expireDate.isBefore(LocalDate.now()) || expireDate.isEqual(LocalDate.now())) {
                System.out.println(" Нужно оформлять новую страховку! ");
            }
        }
         public void checkNumber(){
            if (number.length()!=9){
                System.out.println(" Номер страховки некорректный");
            }
         }

        public void setCost(double cost) {
            this.cost = Objects.requireNonNullElse(cost, 10_000.00);
        }

        public void setNumber(String number) {
            this.number = Objects.requireNonNullElse(number, "123456789");
        }

    }


    public void printInfo() {
        System.out.println("Автомобиль - " + getBrand() + " " + getModel() +
                ", год выпуска - " + getYear() +
                ", сборка -  " + getCountry() +
                ",  цвет - " + getColor() +
                ", максимальная скорость - " + getMaxSpeed() +
                ", объем двигателя -  " + getEngineVolume() +
                " литров, коробка передач - " + getTransmission() +
                ", тип кузова - " + getTypeOfBody() +
                ", регистрационный номер - " + getRegNumber() +
                ", количество мест - " + getSeatsCount() +
                " , " + (isSummerTires() ? "летняя" : "зимняя") + " резина " +
                ",  " + (getKey().isKeylessAccess() ? "доступ без ключа " : "доступ с ключом") +
                ",  " + (getKey().isRemoteRunEngine() ? "удаленный запуск " : "обычный запуск") +
                ", номер страховки - " + getInsurance().getNumber() +
                ", стоимость страховки - " + getInsurance().getCost() +
                ", срок действия страховки - " + getInsurance().getExpireDate() +
                ", тип топлива - " + getFuelType());
    }

}




