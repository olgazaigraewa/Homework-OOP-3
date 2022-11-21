import Transport.Bus;
import Transport.Car;
import Transport.Train;



public class Main {

    public static void main(String[] args) {
        Bus mersedes = new Bus("Mersedes", "Citaco", 2019, "Германия", " жёлтый",
                160, 50, 191, 32, " дизель");
        Bus volvo = new Bus("Volvo", "8900", 2018, "Швеция", " синий",
                160, 50, 27, 57, " дизель");
        Bus man = new Bus("Man", "City", 2020, "Польша", " белый",
                160, 50, 295, 57, " бензин");
        mersedes.printInfo();
        volvo.printInfo();
        man.printInfo();
        mersedes.refill();
        man.refill();
        System.out.println(" ");

        Train lastochka = new Train("Ласточка", "И-901", 2011, "Россия", null, 301,
                3500f, 3, "Белорусский вокзал", "станция Минск-Пассажирский",
                11, "Дизель");
        Train leningrad = new Train("Ленинград", "D-125", 2019, "Россия", null, 270,
                1700f, 5, "Ленинградский вокзал",
                "станция Ленинград-Пассажирский", 8, "Дизель");
        leningrad.printInfo();
        lastochka.printInfo();
        lastochka.refill();
        leningrad.refill();
        System.out.println(" ");

        Car lada = new Car("Lada", " Granta", 2015, "Россия", "желтый", 180,
                1.7,"МКПП", "седан", "А543СЛ354", 5,false,
                null, null, "бензин");
        Car audi = new Car(" Audi", " A8 50 L TDI quattro", 2020, "Германия", null, 200,
                3.0, "АКПП", "кроссовер", "М526РН784", 5, true,
                null, null, "дизель");
        Car bmw = new Car(" BMW", " Z8", 2021, null, "черный", 200,
                3.0,"АКПП"," купе", "К526РН789", 5,
                false, null, null, "дизель");

        Car kia = new Car(" Kia", " Sportage 4-го поколения", 2018, "Южная Корея", "красный",
                190, 0, "МКПП", "седан", "С926РН448", 5,
                false, null, null, "бензин");
        Car hyundai = new Car(" Hyundai ", " Avante", 0, "Южная Корея", "оранжевый",
                190, 1.8, "АКПП", "седан", "С926РН448", 5,
                false, null, null, "электрокар");
        lada.printInfo();
        audi.printInfo();
        bmw.printInfo();
        kia.printInfo();
        hyundai.printInfo();
        lada.refill();
        audi.refill();
        hyundai.refill();


    }
}





